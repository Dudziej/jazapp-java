package pl.edu.pjwstk.jaz.auction;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auctions_in_basket")
public class AuctionsInBasket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "auction_id")
	private Auction auction;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "basket_id")
	private Basket basket;

	@Column(name = "count")
	private Long count;

	@Column(name = "data")
	private Date data;

	public AuctionsInBasket() {
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}
}