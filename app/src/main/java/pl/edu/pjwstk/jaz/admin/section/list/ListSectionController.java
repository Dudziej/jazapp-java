package pl.edu.pjwstk.jaz.admin.section.list;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.section.Section;
import pl.edu.pjwstk.jaz.admin.section.SectionRepository;

@Named
@RequestScoped
public class ListSectionController {
	@Inject
	private SectionRepository rep;

	public List<Section> getSections() {
		return rep.getSections();
	}
}
