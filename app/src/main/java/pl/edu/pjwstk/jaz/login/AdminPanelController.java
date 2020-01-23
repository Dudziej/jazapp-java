package pl.edu.pjwstk.jaz.login;

import pl.edu.pjwstk.jaz.samples.ParamRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AdminPanelController {
    @Inject
    private ParamRetriever paramRetriever;


}
