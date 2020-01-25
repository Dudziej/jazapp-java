package pl.edu.pjwstk.jaz.admin.section;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	@Column(name = "name")
    private String name;

	public Section(String name) {
        this.name = name;
    }

	public Section() {

	}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
