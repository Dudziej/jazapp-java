package pl.edu.pjwstk.jaz.auction;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    public Optional<Auction> getAuctionById(Long id){
        return Optional.ofNullable(em.find(Auction.class, id));
    }

    public Optional<Auction> getAuctionByName(String name){
        TypedQuery<Auction> q = em.createQuery("SELECT a FROM Auction a WHERE a.name = :name", Auction.class);
        q.setParameter("name", name);
        return Optional.ofNullable(q.getSingleResult());
    }

    public List<Auction> getAuctions(){
        Query query = em.createQuery("from Auction", Auction.class);
        return query.getResultList();
    }

    @Transactional
    public Auction saveAuction(Auction auction){
        if (auction.getId() == null) {
            em.persist(auction);
        } else {
            auction = em.merge(auction);
        }
        return auction;
    }

    public void deleteAuction(Auction auction){
        if (em.contains(auction)) {
            em.remove(auction);
        } else {
            em.merge(auction);
        }
    }
}
