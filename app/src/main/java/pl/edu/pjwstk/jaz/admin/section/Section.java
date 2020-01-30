package pl.edu.pjwstk.jaz.admin.section;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.edu.pjwstk.jaz.admin.category.Category;

@Entity
@Table(name = "section")
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", unique = true)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
	private List<Category> categories;

	public Section() {
	}

	public Section(String name) {
		this.name = name;
	}

	public Section(Long id, String name) {
		this(name);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Category> getCategories() {
		return categories;
	}

}
