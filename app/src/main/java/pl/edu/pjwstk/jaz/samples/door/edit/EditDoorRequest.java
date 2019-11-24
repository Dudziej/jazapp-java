package pl.edu.pjwstk.jaz.samples.door.edit;

import pl.edu.pjwstk.jaz.samples.jpa.Door;
import pl.edu.pjwstk.jaz.samples.jpa.Location;

public class EditDoorRequest {
    private Long id;
    private String name;
    private Integer floor;

    public EditDoorRequest() {
    }

    public EditDoorRequest(Door door) {
        this.id = door.getId();
        this.name = door.getLocation().getName();
        this.floor = door.getLocation().getFloor();
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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Door toDoor() {
        return new Door(id, new Location(name, floor));
    }
}
