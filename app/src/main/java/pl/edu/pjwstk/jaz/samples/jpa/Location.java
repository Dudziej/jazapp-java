package pl.edu.pjwstk.jaz.samples.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location {
    @Column(name = "name")
    private String name;

    @Column(name = "floor")
    private Integer floor;

    public Location() {
    }

    public Location(String name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }
}
