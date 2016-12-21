package edu.upc.eetac.dsa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OriolGresa on 21/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtakemonCollection {

    private List<Etakemon> etakemons = new ArrayList<Etakemon>();

    public List<Etakemon> getEtakemons() {
        return etakemons;
    }

    public void setEtakemons(List<Etakemon> etakemons) {
        this.etakemons = etakemons;
    }
}