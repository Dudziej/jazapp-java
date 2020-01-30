package pl.edu.pjwstk.jaz.admin.category;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryRepository {
	@PersistenceContext
	private EntityManager em;

	public Optional<Category> getCategoryById(Long id) {
		return Optional.ofNullable(em.find(Category.class, id));
	}

	public Optional<Category> getCategoryByName(String name) {
		TypedQuery<Category> q = em.createQuery("SELECT a FROM Category a WHERE a.name = :name", Category.class);
		q.setParameter("name", name);
		return q.getResultStream().findAny();
	}

	public List<Category> getCategorys() {
		Query query = em.createQuery("from Category", Category.class);
		return query.getResultList();
	}

	@Transactional
	public Category saveCategory(Category category) {
		if (category.getId() == null) {
			em.persist(category);
		} else {
			category = em.merge(category);
		}
		return category;
	}

	public void deleteCategory(Category category) {
		if (em.contains(category)) {
			em.remove(category);
		} else {
			em.merge(category);
		}
	}
}
