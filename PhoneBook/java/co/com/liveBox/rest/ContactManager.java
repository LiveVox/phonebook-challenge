package co.com.liveBox.rest;

import co.com.liveBox.datamodel.MyBatisConnectionFactory;
import co.com.liveBox.datamodel.dao.ContactDAO;
import co.com.liveBox.datamodel.vo.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("contactManager")
public class ContactManager {

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ContactDAO contactDAO = new ContactDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        return Response.ok(contactDAO.selectAll()).build();
    }

    @GET
    @Path("/findContact")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findContact(@QueryParam("keyWords") List<String> keyWords) {
        if (keyWords.isEmpty()){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        ContactDAO contactDAO = new ContactDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        return Response.ok(contactDAO.findContact(keyWords)).build();
    }

    @PUT
    @Path("/addContact")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addContact(Contact contact) {
        ContactDAO contactDAO = new ContactDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        return Response.ok(contactDAO.addContact(contact)).build();
    }
}
