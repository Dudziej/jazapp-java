package pl.edu.pjwstk.jaz.auth;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@ApplicationScoped
public class ProfileService {
    @Inject
    private ProfileRepository profileRepository;

    @Inject
    private HttpServletRequest request;

    public boolean logIn(String username, String password) {
        if (isUsernameAndPasswordCorrect(username, password)) {
            var session = request.getSession(true);
            session.setAttribute("username", username);

            return true;
        }
        return false;
    }

    private boolean isUsernameAndPasswordCorrect(String username, String password) {
        var userOptional = profileRepository.findUserByUsername(username);
        if (userOptional.isEmpty()) {
            return false;
        }
        var user = userOptional.get();
        return user.getUsername().equals(username) && user.getPassword().equals(password);
    }

    public boolean doesUserExist(String username) {
        //noinspection SimplifyOptionalCallChains // just for learning
        return !profileRepository.findUserByUsername(username).isEmpty();
    }

    public void addUser(String firstName, String lastName, String username, String password) {
        var user = new User(firstName, lastName, username, password);
        profileRepository.addUser(user);
    }

    @PostConstruct
    public void addTest() {
        var user = new User("Admin", "Admin","admin", "admin");
        profileRepository.addUser(user);
    }

    public void logout() {
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
