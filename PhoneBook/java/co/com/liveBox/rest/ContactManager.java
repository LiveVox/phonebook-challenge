package co.com.liveBox.rest;

import co.com.liveBox.datamodel.MyBatisConnectionFactory;
import co.com.liveBox.datamodel.dao.ContactDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("contactManager")
public class ContactManager {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {

        return "THIS GOOD INFO";
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ContactDAO contactDAO = new ContactDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        return Response.ok(contactDAO.selectAll()).build();
    }
}
