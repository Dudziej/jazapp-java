package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.auth.UserContext;
import pl.edu.pjwstk.jaz.samples.ParamRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditAuctionController {
    @Inject
    private AuctionRepository auctionRepository;
    @Inject
    private ParamRetriever paramRetriever;
    @Inject
    private UserContext uc;

    private EditAuctionRequest editAuctionRequest;

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
        if (auction.getCreator() == null) {
            auction.setCreator(uc.getUser().get());
        }
        auctionRepository.saveAuction(auction);

        return "/auctions/auctionlist.xhtml?faces-redirect=true";
    }
}
