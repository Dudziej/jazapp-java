package pl.edu.pjwstk.jaz.admin.section;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class SectionRepository {
	@PersistenceContext
	private EntityManager em;

	public Optional<Section> getSectionById(Long id) {
		return Optional.ofNullable(em.find(Section.class, id));
	}

	public Optional<Section> getSectionByName(String name) {
		TypedQuery<Section> q = em.createQuery("SELECT a FROM Section a WHERE a.name = :name", Section.class);
		q.setParameter("name", name);
		return q.getResultStream().findAny();
	}

	public List<Section> getSections() {
		Query query = em.createQuery("from Section", Section.class);
		return query.getResultList();
	}

	@Transactional
	public Section saveSection(Section section) {
		if (section.getId() == null) {
			em.persist(section);
		} else {
			section = em.merge(section);
		}
		return section;
	}

	public void deleteSection(Section section) {
		if (em.contains(section)) {
			em.remove(section);
		} else {
			em.merge(section);
		}
	}
}
