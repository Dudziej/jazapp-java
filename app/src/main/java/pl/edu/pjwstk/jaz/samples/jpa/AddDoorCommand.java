package pl.edu.pjwstk.jaz.samples.jpa;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class AddDoorCommand {
    @NotEmpty
    private String name;
    @Max(8)
    private Integer floor;

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
}
