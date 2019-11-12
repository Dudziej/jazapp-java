package pl.edu.pjwstk.jaz.login;

import pl.edu.pjwstk.jaz.auth.ProfileService;
import pl.edu.pjwstk.jaz.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    @Inject
    private ProfileService profileService;

    public String login() {
        System.out.println("Tried to log in using " + loginRequest.toString());

        if (profileService.logIn(loginRequest.getUsername(), loginRequest.getPassword())) {
            return "/index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Incorrect username or password");
            return "/login.xhtml?faces-redirect=true";
        }
    }
}
