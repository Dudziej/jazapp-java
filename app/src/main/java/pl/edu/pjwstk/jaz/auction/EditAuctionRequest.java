package pl.edu.pjwstk.jaz.auction;

import javax.swing.text.html.parser.Entity;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Set;

public class EditAuctionRequest {
    private Long id;
    private String name;
    private String description;
    private String photo;
    private Set<ParamEntity> parameters;
    private BigDecimal price;
    private CategoryEntity category;

    public EditAuctionRequest() {
    }

    public EditAuctionRequest(Auction auction) {
        this.id = auction.getId();
        this.name = auction.getName();
        this.description = auction.getDescription();
        this.photo = auction.getPhoto();
        this.parameters = auction.getParameters();
        this.price = auction.getPrice();
        this.category = auction.getCategory();
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
    @DecimalMin(value = "0.0", inclusive = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    public Auction toAuction() {
        return new Auction(id, name, description, photo, parameters, price);
    }
}
