package pl.edu.pjwstk.jaz.samples.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "already_run_sample")
public class AlreadyRunSample {
    @Id
    private String name;

    public AlreadyRunSample() {
    }

    public AlreadyRunSample(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
