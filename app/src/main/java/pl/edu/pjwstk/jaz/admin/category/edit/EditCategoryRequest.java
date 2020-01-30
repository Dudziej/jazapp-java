package pl.edu.pjwstk.jaz.admin.category.edit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class EditCategoryRequest {
    private Long selectedSection;

	public Long getSelectedSection() {
		return selectedSection;
	}

	public void setSelectedSection(Long selectedSection) {
		this.selectedSection = selectedSection;
	}

}
