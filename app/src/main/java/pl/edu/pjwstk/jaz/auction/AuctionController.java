package pl.edu.pjwstk.jaz.auction;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.edu.pjwstk.jaz.admin.category.Category;
import pl.edu.pjwstk.jaz.admin.category.CategoryRepository;
import pl.edu.pjwstk.jaz.auth.UserContext;
import pl.edu.pjwstk.jaz.samples.ParamRetriever;

@Named
@RequestScoped
public class AuctionController {
	@Inject
	private AuctionRepository auctionRepository;
	@Inject
	private CategoryRepository categoryRepository;
	@Inject
	private ParamRetriever paramRetriever;
	@Inject
	private UserContext uc;
	private EditAuctionRequest editAuctionRequest;

	public List<Category> getCategories() {
		return categoryRepository.getCategories();
	}

	public List<Auction> getAuctions() {
		return auctionRepository.getAuctions();
	}

	public EditAuctionRequest getEditRequest() {
		if (editAuctionRequest == null) {
			editAuctionRequest = createEditAuctionRequest();
		}
		return editAuctionRequest;
	}

	private EditAuctionRequest createEditAuctionRequest() {
		if (paramRetriever.contains("auctionId")) {
			var auctionId = paramRetriever.getLong("auctionId");
			var auction = auctionRepository.getAuctionById(auctionId).orElseThrow();
			return new EditAuctionRequest(auction);
		}
		return new EditAuctionRequest();
	}

	public String save() {
		var auction = editAuctionRequest.toAuction();
		System.out.println(editAuctionRequest.getPhotos().size());
		if (auction.getCreator() == null) {
			auction.setCreator(uc.getUser().get());
		}
		Category category = categoryRepository.getCategoryById(editAuctionRequest.getCategoryId()).get();
		auction.setCategory(category);
		auction.getPhotos().forEach(p -> p.setAuction(auction));
		auctionRepository.saveAuction(auction);

		return "/auctions/auctionlist.xhtml?faces-redirect=true";
	}
}
