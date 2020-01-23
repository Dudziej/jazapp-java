package pl.edu.pjwstk.jaz.samples.jaxrs;

import pl.edu.pjwstk.jaz.samples.jpa.AddDoorCommand;
import pl.edu.pjwstk.jaz.samples.jpa.DoorRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Response;

@Path("/door")
public class DoorResource {
    @Inject
    private DoorRepository doorRepository;

    @POST
    public Response addDoor(@Valid AddDoorCommand addDoorCommand) {
        return Response.ok().build();
    }

    @GET
    @Path("{doorId}")
    public Response getDoor(@PathParam("doorId") Long doorId) {
        var doorById = doorRepository.findDoorById(doorId).orElseThrow();
        return Response.ok()
                .entity(doorById)
                .build();
    }
}
