package pl.edu.pjwstk.jaz.auction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.DecimalMin;

import pl.edu.pjwstk.jaz.auth.User;

public class EditAuctionRequest {
	private Long id;
	private String name;
	private String description;
	private List<Photo> photos;
	private Set<ParamEntity> parameters;
	private BigDecimal price;
	private Long categoryId;
	private User creator;

	public EditAuctionRequest() {
		photos = new ArrayList<>();
		addPhoto();
	}

	public EditAuctionRequest(Auction auction) {
		this.id = auction.getId();
		this.name = auction.getName();
		this.description = auction.getDescription();
		this.photos = auction.getPhotos();
		this.parameters = auction.getParameters();
		this.price = auction.getPrice();
		this.categoryId = auction.getCategory().getId();
		this.photos = auction.getPhotos();
		this.creator = auction.getCreator();
	}

	public void addPhoto() {
		photos.add(new Photo());
	}

	public void removePhoto(Photo photo) {
		for (Iterator<Photo> i = photos.iterator(); i.hasNext();) {
			var p = i.next();
			if (p.getId() == photo.getId()) {
				i.remove();
				break;
			}
		}
	}

	public Auction toAuction() {
		return new Auction(id, name, description, photos, parameters, price);
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

	@DecimalMin(value = "0.0", inclusive = false)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}
