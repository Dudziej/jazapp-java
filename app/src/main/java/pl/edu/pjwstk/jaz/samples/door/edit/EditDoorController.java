package pl.edu.pjwstk.jaz.samples.door.edit;

import pl.edu.pjwstk.jaz.samples.ParamRetriever;
import pl.edu.pjwstk.jaz.samples.jpa.DoorRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditDoorController {
    @Inject
    private DoorRepository doorRepository;

    @Inject
    private ParamRetriever paramRetriever;

    private EditDoorRequest editDoorRequest;

    public EditDoorRequest getEditRequest() {
        if (editDoorRequest == null) {
            editDoorRequest = createEditDoorRequest();
        }
        return editDoorRequest;
    }

    private EditDoorRequest createEditDoorRequest() {
        if (paramRetriever.contains("doorId")) {
            var doorId = paramRetriever.getLong("doorId");
            var door = doorRepository.findDoorById(doorId).orElseThrow();
            return new EditDoorRequest(door);
        }
        return new EditDoorRequest();
    }

    public String save() {
        var door = editDoorRequest.toDoor();
        doorRepository.save(door);

        return "/samples/doorlist.xhtml?faces-redirect=true";
    }
}
