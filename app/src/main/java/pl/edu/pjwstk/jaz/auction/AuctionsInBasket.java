package pl.edu.pjwstk.jaz.auction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="auctions_in_basket")
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

    public AuctionsInBasket{
    }

}