package pl.edu.pjwstk.jaz.auction;

import javax.persistence.*;

@Entity
@Table(name ="photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    public Photo() {
    }

    public Photo(Long id, String path, Auction auction) {
        this.id = id;
        this.path = path;
        this.auction = auction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
