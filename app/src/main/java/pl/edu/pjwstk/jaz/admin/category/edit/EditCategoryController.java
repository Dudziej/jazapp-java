package pl.edu.pjwstk.jaz.admin.category.edit;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.category.Category;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.admin.section.Section;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.samples.ParamRetriever;

@RequestScoped
@Named
public class EditCategoryController {
	@Inject
	EditCategoryRequest categoryRequest;
	private EditCategoryRequest editRequest;
	@Inject
	private CategoryRepository categoryRepository;
	@Inject
	private SectionRepository sectionRepository;
	@Inject
	private ParamRetriever paramRetriever;

	public EditCategoryRequest getEditRequest() {
		if (editRequest == null) {
			editRequest = createEditCategoryRequest();
		}
		return editRequest;
	}

	public List<Section> getSections() {
		return sectionRepository.getSections();
	}

	private EditCategoryRequest createEditCategoryRequest() {
		if (paramRetriever.contains("categoryId")) {
			var categoryId = paramRetriever.getLong("categoryId");
			var category = categoryRepository.getCategoryById(categoryId).orElseThrow();
			return new EditCategoryRequest(category);
		}
		return new EditCategoryRequest();
	}

	public String save() {
		var category = editRequest.toCategory();
		Optional<Category> s = categoryRepository.getCategoryByName(category.getName());
		if (s.isPresent() && s.get().getId() != category.getId()) {
			FacesMessage message = new FacesMessage("Already exists");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("category-name", message);
			return null;
		}
		var section = sectionRepository.getSectionById(editRequest.getSectionId()).get();
		category.setSection(section);
		categoryRepository.saveCategory(category);
		return "/admin/categorylist.xhtml?faces-redirect=true";
	}
}
