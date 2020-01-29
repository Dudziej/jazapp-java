package pl.edu.pjwstk.jaz.admin.category.edit;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.section.Section;
import pl.edu.pjwstk.jaz.admin.section.edit.EditSectionRequest;

@RequestScoped
@Named
public class EditCategoryController {
    @Inject
    EditSectionRequest sectionRequest;

	public List<Section> getSelectExampleOptions() {
		final ArrayList<Section> selectExamples = new ArrayList<>();
        return selectExamples;
    }

    public void save() {
        var selectedId = sectionRequest.getExampleSelectedId();

        System.out.println("Selected id is equal to " + selectedId);
    }
}
