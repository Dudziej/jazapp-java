package pl.edu.pjwstk.jaz.admin.section.edit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class EditSectionController {
    @Inject
    EditSectionRequest sectionRequest;

    public void save() {
        var selectedId = sectionRequest.getExampleSelectedId();

        System.out.println("Selected id is equal to " + selectedId);
    }
}
