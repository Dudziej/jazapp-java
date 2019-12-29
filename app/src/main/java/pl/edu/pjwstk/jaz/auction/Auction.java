package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.auth.ProfileEntity;
import pl.edu.pjwstk.jaz.auth.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "auction_param",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    private Set<ParamEntity> parameters;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "auction_category",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private CategoryEntity category;
    @Column(name = "price")
    @DecimalMin(inclusive = true, value = "1")
    private BigDecimal price = new BigDecimal(1);
    @ManyToOne
    @JoinColumn(name="creator_id")
    private User creator;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public void Category(CategoryEntity category) {
        this.category = category;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
}
