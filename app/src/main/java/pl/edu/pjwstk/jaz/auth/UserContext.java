package pl.edu.pjwstk.jaz.auth;

import pl.edu.pjwstk.jaz.auction.Auction;
import pl.edu.pjwstk.jaz.auction.AuctionRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Named
@RequestScoped
public class UserContext {
    @Inject
    private HttpServletRequest request;

    @Inject
    private UserRepository userRepository;
    @Inject
    private AuctionRepository auctionRepository;

    public String getUsername() {
        var session = request.getSession(false);
        var usernameObj = session.getAttribute("username");
        if (usernameObj == null) {
            throw new IllegalStateException("No session/User not logged in.");
        }

        return (String) usernameObj;
    }

    public String getFullName() {
        var username = getUsername();

        var user = userRepository.getUserByUsername(username).get();

        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }

    public boolean isAdmin() {
        var username = getUsername();
        var user = userRepository.getUserByUsername(username).get();
        return user.isAdmin();
    }

    public boolean hasAccessToAuction(Long auctionId) {
        if (isAdmin()) {
            return true;
        }
        var user = getUser();
        Optional<Auction> a = auctionRepository.getAuctionById(auctionId);
        if (a.isEmpty()) {
            return false;
        }
        return a.get().getCreator().getUsername().equals(user.get().getUsername());
    }

    public Optional<User> getUser() {
        var username = getUsername();
        var user = userRepository.getUserByUsername(username).get();
        return Optional.ofNullable(user);
    }
}
