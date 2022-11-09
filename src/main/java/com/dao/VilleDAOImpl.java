package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO {

    private int i = 0;

    public ArrayList<Ville> findAllVilles() throws SQLException {
        String jdbcURL = "jdbc:h2:tcp://localhost/~/test";

        Connection connection = DriverManager.getConnection(jdbcURL, "SA", "");

        System.out.println("Connected to H2 in-memory database.");

        String sql = "Select * from VILLE_FRANCE";

        Statement statement = connection.createStatement();

        ResultSet bdd = statement.executeQuery(sql);
        ResultSetMetaData rsmd = bdd.getMetaData();

        ArrayList<Ville> listVille = new ArrayList<>();

        while (bdd.next()) {
            this.i += 1;
            listVille.add(new Ville());
            listVille.get(i - 1).setCodeCommune(bdd.getString(1));
            listVille.get(i - 1).setLigne(bdd.getString(5));
            listVille.get(i - 1).setCodePostal(bdd.getString(3));
            listVille.get(i - 1).setLibelleAcheminement(bdd.getString(4));
            listVille.get(i - 1).setNomCommune(bdd.getString(2));
        }
        connection.close();

        System.out.println("findAlVilles");

        return listVille;
    }
}
