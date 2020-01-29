package pl.edu.pjwstk.jaz.admin.category.edit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class EditCategoryRequest {
    private Long exampleSelectedId;

    public Long getExampleSelectedId() {
        return exampleSelectedId;
    }

    public void setExampleSelectedId(Long exampleSelectedId) {
        this.exampleSelectedId = exampleSelectedId;
    }
}
