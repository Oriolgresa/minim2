package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.entity.Etakemon;
import edu.upc.eetac.dsa.entity.EtakemonCollection;

import java.sql.SQLException;

/**
 * Created by OriolGresa on 21/12/16.
 */
public interface EtakemonDAO {
    public EtakemonCollection createEtakemonIntoUser(int idetakemon, int iduser) throws SQLException;
    public EtakemonCollection getEtakemonsFromUser(int iduser) throws SQLException;
    public Etakemon getEtakemon(String nom) throws SQLException;
}