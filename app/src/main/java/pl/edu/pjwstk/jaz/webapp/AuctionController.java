package pl.edu.pjwstk.jaz.webapp;

import pl.edu.pjwstk.jaz.auth.ProfileRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Named
@RequestScoped
@Path("/auction")
public class AuctionController {
@Inject
    private ProfileRepository rep;

@GET
    @Path("/")
    public String getAll(){

    return "auction_all";
}
}
