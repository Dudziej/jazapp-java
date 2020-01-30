package pl.edu.pjwstk.jaz.admin.category.edit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.category.Category;

@RequestScoped
@Named
public class EditCategoryRequest {
	private Long id;
	private String name;
	private Long sectionId;

	public EditCategoryRequest(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.sectionId = category.getSection().getId();
	}

	public EditCategoryRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public Category toCategory() {
		return new Category(id, name);
	}

}
