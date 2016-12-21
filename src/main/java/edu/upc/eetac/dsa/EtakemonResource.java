package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.dao.EtakemonDAO;
import edu.upc.eetac.dsa.dao.EtakemonDAOImpl;
import edu.upc.eetac.dsa.entity.Etakemon;
import edu.upc.eetac.dsa.entity.EtakemonCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Path("etakemon")
public class EtakemonResource {
    @Context
    private SecurityContext securityContext;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(EtakemonMediaType.ETAKEMON_COLLECTION)
    public EtakemonCollection createEtakemonIntoUser(@FormParam("idetakemon") int idetakemon, @FormParam("iduser") int iduser) throws URISyntaxException {
        if(idetakemon == 0 || iduser == 0)
            throw new BadRequestException("all parameters are mandatory");
        EtakemonDAO etakemonDAO = new EtakemonDAOImpl();
        EtakemonCollection etakemonCollection = null;
        try {
            etakemonCollection = etakemonDAO.createEtakemonIntoUser(idetakemon, iduser);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return etakemonCollection;
    }

    @Path("/{iduser}")
    @GET
    @Produces(EtakemonMediaType.ETAKEMON_COLLECTION)
    public EtakemonCollection getEtakemonsFromUser(@PathParam("iduser") int iduser) {
        EtakemonCollection etakemonCollection = null;
        EtakemonDAO etakemonDAO = new EtakemonDAOImpl();
        try {
            etakemonCollection = etakemonDAO.getEtakemonsFromUser(iduser);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return etakemonCollection;
    }

    @Path("/{nom}")
    @GET
    @Produces(EtakemonMediaType.ETAKEMON_COLLECTION)
    public Etakemon getEtakemon(@PathParam("nom") String nom) {
        Etakemon etakemon = null;
        EtakemonDAO etakemonDAO = new EtakemonDAOImpl();
        try {
            etakemon = etakemonDAO.getEtakemon(nom);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        return etakemon;
    }
}