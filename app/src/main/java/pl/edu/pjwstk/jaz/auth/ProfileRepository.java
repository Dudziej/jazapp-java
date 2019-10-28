package pl.edu.pjwstk.jaz.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProfileRepository {
    @PersistenceContext
    private EntityManager em;

    // startTx()
    @Transactional
    public void sampleCodeWithPC() {
        var profile = new ProfileEntity("pjanowiak");

        em.persist(profile);

        final ProfileEntity profileEntity = em.find(ProfileEntity.class, 7L);
        var list = em.createQuery("from ProfileEntity where name = :name", ProfileEntity.class)
                .setParameter("name", "pjanowiak2")
                .getResultList();

        var passwordEncoder = new BCryptPasswordEncoder();
        final String rawPassword = "xGdXi7Qb5EK4";

        System.out.println("hashed password try 1: " + passwordEncoder.encode(rawPassword));
        final String hashedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("hashed password try 2: " + hashedPassword);

        System.out.println("Does password match?: " + passwordEncoder.matches(rawPassword, hashedPassword));

        System.out.println();
    }
    // commitTx()
}
