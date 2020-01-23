package pl.edu.pjwstk.jaz.admin.section.edit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class EditSectionController {
    @Inject
    EditSectionRequest sectionRequest;

    public List<SelectExample> getSelectExampleOptions() {
        final ArrayList<SelectExample> selectExamples = new ArrayList<>();
        selectExamples.add(new SelectExample(1L, "option1"));
        selectExamples.add(new SelectExample(2L, "option2"));
        selectExamples.add(new SelectExample(3L, "option3"));
        return selectExamples;
    }

    public void save() {
        var selectedId = sectionRequest.getExampleSelectedId();

        System.out.println("Selected id is equal to " + selectedId);
    }
}
