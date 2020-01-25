package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.auth.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @DecimalMin(inclusive = true, value = "1")
    private BigDecimal price = new BigDecimal(1);

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(name = "edited")
    private boolean edited;

    @OneToMany(
            mappedBy = "auction",
            cascade= {CascadeType.MERGE, CascadeType.REMOVE},
            orphanRemoval = true)
    private List<Photo> photos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "auction_param",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_id"))
    private Set<ParamEntity> parameters;

    public Auction() {
    }

    public Auction(Long id, String name, @DecimalMin(inclusive = true, value = "1") BigDecimal price, String description,
                   User creator, CategoryEntity category, boolean edited, List<Photo> photos, Set<ParamEntity> parameters) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.creator = creator;
        this.category = category;
        this.edited = edited;
        this.photos = photos;
        this.parameters = parameters;
    }

    public Auction(Long id, String name, String description, List<Photo> photos, Set<ParamEntity> parameters, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.parameters = parameters;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Set<ParamEntity> getParameters() {
        return parameters;
    }

    public void setParameters(Set<ParamEntity> parameters) {
        this.parameters = parameters;
    }
}