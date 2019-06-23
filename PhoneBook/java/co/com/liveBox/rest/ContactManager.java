package co.com.liveBox.rest;

import co.com.liveBox.datamodel.MyBatisConnectionFactory;
import co.com.liveBox.datamodel.dao.ContactDAO;
import co.com.liveBox.datamodel.vo.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

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
        try {
            validateContact(contact);
            ContactDAO contactDAO = new ContactDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            return Response.ok(contactDAO.addContact(contact)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    private void validateContact(Contact contact) {
        Optional.ofNullable(contact)
                .orElseThrow(() -> new IllegalArgumentException("Contact must not be empty"));
        Optional.ofNullable(contact.getName())
                .orElseThrow(() -> new IllegalArgumentException("Contact's name must not be empty"));
        Optional.ofNullable(contact.getLastname())
                .orElseThrow(() -> new IllegalArgumentException("Contact's lastname must not be empty"));
        Optional.ofNullable(contact.getPhone())
                .orElseThrow(() -> new IllegalArgumentException("Contact's phone must not be empty"));
    }
}
