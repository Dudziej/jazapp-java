package pl.edu.pjwstk.jaz.auction;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

@ApplicationScoped
public class AuctionRepository {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction userTransaction;

	public Optional<Auction> getAuctionById(Long id) {
		return Optional.ofNullable(em.find(Auction.class, id));
	}

	public Optional<Auction> getAuctionByName(String name) {
		TypedQuery<Auction> q = em.createQuery("SELECT a FROM Auction a WHERE a.name = :name", Auction.class);
		q.setParameter("name", name);
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
		return auction;
	}

	public void deleteAuction(Auction a) {
		try {
			userTransaction.begin();
			var id = a.getId();
			Optional<Auction> ao = getAuctionById(id);
			if (ao.isPresent()) {
				em.remove(em.merge(a));
			}
			userTransaction.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
