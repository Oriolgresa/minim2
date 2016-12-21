package edu.upc.eetac.dsa.dao;

/**
 * Created by OriolGresa on 21/12/16.
 */
public interface EtakemonDAOQuery {
    public final static String INSERT_ETAKEMONTOUSER = "insert into relacionUserEtakemons (idUser, idEtakemon) values (?, ?)";
    public final static String GET_ETAKEMONSFOMUSER = "select * from relacionUserEtakemons where iduser=";
    public final static String GET_ETAKEMON = "select * from etakemon where nom=?";
}