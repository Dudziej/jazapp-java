package pl.edu.pjwstk.jaz.auth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import pl.edu.pjwstk.jaz.admin.category.Category;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.admin.section.Section;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;

@ApplicationScoped
public class ProfileService {
    @Inject
    private UserRepository userRepository;
    @Inject
	private SectionRepository sectionRepository;
	@Inject
	private CategoryRepository categoryRepository;
	@Inject
    private HttpServletRequest request;

    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public boolean logIn(String username, String password) {
        if (isUsernameAndPasswordCorrect(username, password)) {
            var session = request.getSession(true);
            session.setAttribute("username", username);

            return true;
        }
        return false;
    }

    private boolean isUsernameAndPasswordCorrect(String username, String password) {
        var userOptional = userRepository.getUserByUsername(username);
        if (userOptional.isEmpty()) {
            return false;
        }
        var user = userOptional.get();
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    public boolean doesUserExist(String username) {
        //noinspection SimplifyOptionalCallChains // just for learning
        return !userRepository.getUserByUsername(username).isEmpty();
    }

    public void addUser(String firstName, String lastName, String username, String password, String email, String birthday) {
        var user = new User(firstName, lastName, username, password, email, parseDate(birthday));
        userRepository.addUser(user);
    }

    private LocalDate parseDate(String dateAsText) {
        try {
            var parsedDate = dateFormat.parse(dateAsText);

            return parsedDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void addTest() {
        if (!userRepository.getUserByUsername("admin").isPresent()) {
            var admin = new User("Admin", "Admin", "admin", "admin",
                    "admin@admin.pl", LocalDate.parse("2007-12-03"));
            admin.setAdmin(true);
            userRepository.addUser(admin);
            var user = new User("User", "Nonadmin", "user", "user",
                    "admin@admin.pl", LocalDate.parse("2007-12-03"));
            userRepository.addUser(user);
        }
		if (!sectionRepository.getSectionByName("RTV").isPresent()) {
			var s1 = new Section("RTV");
			sectionRepository.saveSection(s1);
			var s2 = new Section("AGD");
			sectionRepository.saveSection(s2);
		}
		if (!categoryRepository.getCategoryByName("Monitors").isPresent()) {
			var c1 = new Category("Monitors", sectionRepository.getSectionByName("RTV").get());
			categoryRepository.saveCategory(c1);
			var c2 = new Category("Keys", sectionRepository.getSectionByName("RTV").get());
			categoryRepository.saveCategory(c2);
		}
    }

    public void logout() {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
