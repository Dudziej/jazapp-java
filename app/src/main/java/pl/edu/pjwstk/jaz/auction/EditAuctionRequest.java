package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.samples.jpa.Door;
import pl.edu.pjwstk.jaz.samples.jpa.Location;

import java.math.BigDecimal;

public class EditAuctionRequest {
    private Long id;
    private String name;
    private String description;
    private String photo;
    private String parameters;
    private BigDecimal price;

    public EditAuctionRequest() {
    }

    public EditAuctionRequest(Auction auction) {
        this.id = auction.getId();
        this.name = auction.getName();
        this.description = auction.getDescription();
        this.photo = auction.getPhoto();
        //this.parameters = auction.getParameters();
        this.price = auction.getPrice();
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

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Auction toAuction() {
        return new Auction(id, name, description, photo, null, price);
    }
}
