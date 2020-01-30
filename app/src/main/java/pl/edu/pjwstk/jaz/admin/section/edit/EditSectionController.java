package pl.edu.pjwstk.jaz.admin.section.edit;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.section.Section;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;
import pl.edu.pjwstk.jaz.samples.ParamRetriever;

@RequestScoped
@Named
public class EditSectionController {
	private EditSectionRequest editRequest;
	@Inject
	private SectionRepository sectionRepository;
	@Inject
	private ParamRetriever paramRetriever;

	public EditSectionRequest getEditRequest() {
		if (editRequest == null) {
			editRequest = createEditSectionRequest();
		}
		return editRequest;
	}

	private EditSectionRequest createEditSectionRequest() {
		if (paramRetriever.contains("sectionId")) {
			var sectionId = paramRetriever.getLong("sectionId");
			var section = sectionRepository.getSectionById(sectionId).orElseThrow();
			return new EditSectionRequest(section);
		}
		return new EditSectionRequest();
	}

	public String save() {
		var section = editRequest.toSection();
		Optional<Section> s = sectionRepository.getSectionByName(section.getName());
		if (s.isPresent() && s.get().getId() != section.getId()) {
			FacesMessage message = new FacesMessage("Already exists");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("section-name", message);
			return null;
		}

		sectionRepository.saveSection(section);
		return "/admin/sectionlist.xhtml?faces-redirect=true";
	}
}
