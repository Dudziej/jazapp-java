package pl.edu.pjwstk.jaz.register;

import pl.edu.pjwstk.jaz.auth.ProfileService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterController {
    @Inject
    private RegisterRequest registerRequest;

    @Inject
    private ProfileService profileService;

    public String register() {
        if (profileService.doesUserExist(registerRequest.getUsername())) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("already-exists", "Username already exists.");
            return "register.xhtml?faces-redirect=true";
        }

        profileService.addUser(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getEmail(),
                registerRequest.getBirthDate()
        );

        return "login.xhtml?faces-redirect=true";
    }
}
