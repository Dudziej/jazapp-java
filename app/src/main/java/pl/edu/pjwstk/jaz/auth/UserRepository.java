package pl.edu.pjwstk.jaz.auth;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    public Optional<User> getUserByUsername(String username) {
        TypedQuery<User> q = em.createQuery("SELECT a FROM User a WHERE a.username = :username", User.class);
        q.setParameter("username", username);
        return q.getResultList().stream().findFirst();
    }

    public List<User> getUsers() {
        Query query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    public void addUser(User user) {
        if (getUserByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException(String.format("User %s already exists.", user.getUsername()));
        }
        saveUser(user);
    }

    @Transactional
    public User saveUser(User user) {
        if (user.getId() == null) {
            em.persist(user);
        } else {
            user = em.merge(user);
        }
        return user;
    }

    @Transactional
    public void deleteUser(User user) {
        if (em.contains(user)) {
            em.remove(user);
        } else {
            em.merge(user);
        }
    }
}
