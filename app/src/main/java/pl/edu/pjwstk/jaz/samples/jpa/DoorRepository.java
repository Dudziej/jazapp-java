package pl.edu.pjwstk.jaz.samples.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DoorRepository {
    @PersistenceContext
    EntityManager em;

    public Optional<Door> findDoorById(Long doorId) {
        var door = em.find(Door.class, doorId);
        return Optional.ofNullable(door);
    }

    @Transactional
    public Door save(Door door) {
        if (door.getId() == null) {
            em.persist(door);
        } else {
            door = em.merge(door);
        }
        return door;
    }

    public List<Door> findAll() {
        return em.createQuery("from Door", Door.class).getResultList();
    }
}
