package co.com.liveBox.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("contactManager")
public class ContactManager {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {

        return "THIS GOOD INFO";
    }
}
