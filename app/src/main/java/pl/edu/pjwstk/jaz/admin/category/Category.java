package pl.edu.pjwstk.jaz.admin.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.edu.pjwstk.jaz.admin.section.Section;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	private Section section;

	public Category(String name) {
		this.name = name;
	}

	public Category(Long id, String name) {
		this(name);
		this.id = id;
	}

	public Category() {
	}

	public Category(String name, Section section) {
		this(name);
		this.section = section;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Section getSection() {
		return section;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
