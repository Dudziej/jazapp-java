package pl.edu.pjwstk.jaz.auction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @ManyToMany
    @JoinTable(
            name = "auction_param",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    private Set<ParamEntity> parameters;
    @Column(name = "price")
    private BigDecimal price = new BigDecimal(1);

    public Auction(Long id, String name, String description, String photo, Set<ParamEntity> parameters, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.parameters = parameters;
        this.price = price == null ? new BigDecimal(1) : price;
    }

    public Auction() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<ParamEntity> getParameters() {
        return parameters;
    }

    public void setParameters(Set<ParamEntity> parameters) {
        this.parameters = parameters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
