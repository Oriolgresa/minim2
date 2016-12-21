package edu.upc.eetac.dsa.dao;

import edu.upc.eetac.dsa.entity.Etakemon;
import edu.upc.eetac.dsa.entity.EtakemonCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by OriolGresa on 21/12/16.
 */
public class EtakemonDAOImpl implements EtakemonDAO {

    @Override
    public EtakemonCollection createEtakemonIntoUser(int idetakemon, int iduser) throws SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(EtakemonDAOQuery.INSERT_ETAKEMONTOUSER);

            stmt.setString(1, iduser+"");
            stmt.setString(2, idetakemon+"");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        return getEtakemonsFromUser(iduser);
    }

    @Override
    public EtakemonCollection getEtakemonsFromUser(int iduser) throws SQLException {
        EtakemonCollection etakemonCollection = new EtakemonCollection();

        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(EtakemonDAOQuery.GET_ETAKEMONSFOMUSER);
            stmt.setString(1, iduser+"");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Etakemon etakemon = new Etakemon();
                etakemon.setId(rs.getInt("id"));
                etakemon.setTipus(rs.getString("tipus"));
                etakemon.setNom(rs.getString("nom"));
                etakemon.setDescripcio(rs.getString("descripcio"));
                etakemon.setPuntuacio(rs.getInt("puntuacio"));
                etakemonCollection.getEtakemons().add(etakemon);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return etakemonCollection;
    }

    @Override
    public Etakemon getEtakemon(String nom) throws SQLException {
        Etakemon etakemon = new Etakemon();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(EtakemonDAOQuery.GET_ETAKEMON);
            stmt.setString(1, nom);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                etakemon.setId(rs.getInt("id"));
                etakemon.setTipus(rs.getString("tipus"));
                etakemon.setNom(rs.getString("nom"));
                etakemon.setDescripcio(rs.getString("descripcio"));
                etakemon.setPuntuacio(rs.getInt("puntuacio"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return etakemon;
    }

}