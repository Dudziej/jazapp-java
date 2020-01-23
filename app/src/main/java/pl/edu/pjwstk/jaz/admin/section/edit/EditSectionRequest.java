package pl.edu.pjwstk.jaz.admin.section.edit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class EditSectionRequest {
    private Long exampleSelectedId;

    public Long getExampleSelectedId() {
        return exampleSelectedId;
    }

    public void setExampleSelectedId(Long exampleSelectedId) {
        this.exampleSelectedId = exampleSelectedId;
    }
}
