package pl.edu.pjwstk.jaz.samples.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class JpaExample {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void runExample() {
        // just to run this sample once
        if (em.find(AlreadyRunSample.class, "jpa") != null) {
            return;
        }
        var door1 = new Door(new Location("backdoor", 0));
        var door2 = new Door(new Location("second floor & front", 1));
        em.persist(door1);
        em.persist(door2);

        var cardHolder = new CardHolder("John", "Doe");
        var card = new Card(123245L, CardType.NFC, cardHolder);
        em.persist(card);

        var retrievedCard  = em.createQuery("from Card where number = :number", Card.class)
                .setParameter("number", 123245L)
                .getSingleResult();

        var cardAccess = new CardAccess(card, door1, 9, 18);
        em.persist(cardAccess);


        em.persist(new AlreadyRunSample("jpa"));
    }
}
