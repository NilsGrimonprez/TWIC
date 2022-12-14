package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO {

    public ArrayList<Ville> findAllVilles() throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

        Connection connection = DriverManager.getConnection(jdbcURL, "SA", "");

        System.out.println("Connected to H2 in-memory database.");

        String sql = "Select * from VILLE_FRANCE";

        Statement statement = connection.createStatement();

        ResultSet bdd = statement.executeQuery(sql);
        ResultSetMetaData rsmd = bdd.getMetaData();

        ArrayList<Ville> listVille = new ArrayList<>();
        int i = 0;

        while (bdd.next()) {
            i += 1;
            listVille.add(new Ville());
            listVille.get(i - 1).setCodeCommune(bdd.getString(1));
            listVille.get(i - 1).setLigne(bdd.getString(5));
            listVille.get(i - 1).setCodePostal(bdd.getString(3));
            listVille.get(i - 1).setLibelleAcheminement(bdd.getString(4));
            listVille.get(i - 1).setNomCommune(bdd.getString(2));
            listVille.get(i - 1).setLatitude(bdd.getString(6));
            listVille.get(i - 1).setLongitude(bdd.getString(7));
        }
        connection.close();

        return listVille;
    }

    public Ville findVille(String codeCommune) throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
        Connection connection = DriverManager.getConnection(jdbcURL, "SA", "");
        System.out.println("Connected to H2 in-memory database.");
        String sql = "Select * From VILLE_FRANCE WHERE CODE_COMMUNE_INSEE = '"+codeCommune+"'";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (!rs.next()) {
            return null;
        }
        else{
            //while (rs.next()){
                Ville ville = new Ville();
                ville.setCodeCommune(rs.getString("CODE_COMMUNE_INSEE"));
                ville.setNomCommune(rs.getString("NOM_COMMUNE"));
                ville.setCodePostal(rs.getString("CODE_POSTAL"));
                ville.setLibelleAcheminement(rs.getString("LIBELLE_ACHEMINEMENT"));
                ville.setLigne(rs.getString("LIGNE_5"));
                ville.setLatitude(rs.getString("LATITUDE"));
                ville.setLongitude(rs.getString("LONGITUDE"));
                connection.close();
                return ville;
            //}
        }
    }

    public Ville addVille(Ville ville) throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
        Connection connection = DriverManager.getConnection(jdbcURL, "SA", "");
        System.out.println("Connected to H2 in-memory database.");
        String sql = "INSERT INTO `ville_france` (`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES " +
                "('" + ville.getCodeCommune() + "', '" + ville.getNomCommune() + "','" + ville.getCodePostal() + "', '" + ville.getLibelleAcheminement() + "', '" + ville.getLigne() + "', '" + ville.getLatitude() + "', '" + ville.getLongitude() + "');";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
        return ville;
    }

    public void deleteVille(String codeCommune) throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
        Connection connection = DriverManager.getConnection(jdbcURL, "SA", "");
        System.out.println("Connected to H2 in-memory database.");
        String sql = "DELETE FROM VILLE_FRANCE WHERE CODE_COMMUNE_INSEE = '" + codeCommune + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }

    public Ville editVille(Ville ville) throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";
        Connection connection = DriverManager.getConnection(jdbcURL, "SA", "");
        System.out.println("Connected to H2 in-memory database.");
        String sql = "UPDATE VILLE_FRANCE SET NOM_COMMUNE = '" + ville.getNomCommune() + "',CODE_POSTAL = '" + ville.getCodePostal() + "', LIBELLE_ACHEMINEMENT = '" + ville.getLibelleAcheminement() + "',LIGNE_5 = '" + ville.getLigne() + "',LATITUDE = '" + ville.getLatitude() + "', LONGITUDE = '" + ville.getLongitude() + "' WHERE CODE_COMMUNE_INSEE = '" + ville.getCodeCommune() + "'";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
        return ville;
    }
}
