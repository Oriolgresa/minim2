package edu.upc.eetac.dsa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.research.ws.wadl.Link;
import org.glassfish.jersey.linking.InjectLinks;

import java.util.List;

/**
 * Created by OriolGresa on 21/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthToken {

    @InjectLinks({})
    private List<Link> links;

    private String userid;
    private String token;

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
