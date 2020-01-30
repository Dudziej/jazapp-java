package pl.edu.pjwstk.jaz.admin.category.list;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.category.Category;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;

@Named
@RequestScoped
public class ListCategoryController {
	@Inject
	private CategoryRepository rep;

	public List<Category> getCategories() {
		return rep.getCategories();
	}
}
