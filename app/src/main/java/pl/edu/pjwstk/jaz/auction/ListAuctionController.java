package pl.edu.pjwstk.jaz.auction;

import pl.edu.pjwstk.jaz.auth.UserContext;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.List;

@Named
@RequestScoped
public class ListAuctionController {

    @Inject
    private AuctionRepository rep;
    @Inject
    private UserContext context;

    public List<Auction> getAuctionList() {
        return rep.getAuctions();
    }
}
