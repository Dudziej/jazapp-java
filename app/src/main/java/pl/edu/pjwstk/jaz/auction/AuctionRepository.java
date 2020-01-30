package pl.edu.pjwstk.jaz.auction;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import pl.edu.pjwstk.jaz.auth.User;

@ApplicationScoped
public class AuctionRepository {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction userTransaction;

	public Optional<Auction> getAuctionById(Long id) {
		return Optional.ofNullable(em.find(Auction.class, id));
	}

	public Optional<Auction> getAuctionByNameAndUser(String name, User user) {
		TypedQuery<Auction> q = em.createQuery("SELECT a FROM Auction a WHERE a.name = :name AND a.creator = :creator",
				Auction.class);
		q.setParameter("name", name);
		q.setParameter("creator", user);
		return Optional.ofNullable(q.getSingleResult());
	}

	public List<Auction> getAuctions() {
		Query query = em.createQuery("from Auction", Auction.class);
		return query.getResultList();
	}

	@Transactional
	public Auction saveAuction(Auction auction) {
		if (auction.getId() == null) {
			em.persist(auction);
		} else {
			auction = em.merge(auction);
		}
		auction.getPhotos().forEach(p -> { // cascade ALL nie dziala
			if (p.getId() == null) {
				em.persist(p);
			} else {
				em.merge(p);
			}
		});
		return auction;
	}

	@Transactional
	public void deleteAuction(Auction a) {
		var id = a.getId();
		Optional<Auction> ao = getAuctionById(id);
		if (ao.isPresent()) {
			em.remove(em.merge(a));
		}
	}
}
