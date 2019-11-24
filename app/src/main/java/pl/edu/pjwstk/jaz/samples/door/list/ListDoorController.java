package pl.edu.pjwstk.jaz.samples.door.list;

import pl.edu.pjwstk.jaz.samples.jpa.Door;
import pl.edu.pjwstk.jaz.samples.jpa.DoorRepository;
import pl.edu.pjwstk.jaz.samples.jpa.Location;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ListDoorController {

    @Inject
    private DoorRepository doorRepository;

    public List<Door> getDoorList() {
        return doorRepository.findAll();
    }
}
