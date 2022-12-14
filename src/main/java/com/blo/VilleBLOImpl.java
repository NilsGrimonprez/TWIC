package com.blo;

import com.dao.VilleDAO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class VilleBLOImpl implements VilleBLO{

    @Autowired
    private VilleDAO villeDAO;

    public Ville getInfoVille(String code) throws SQLException{
        Ville ville = villeDAO.findVille(code);
        return ville;
    }

    public ArrayList<Ville> getInfoVilles() throws SQLException {
        ArrayList<Ville> listVille = new ArrayList<Ville>();
        listVille = villeDAO.findAllVilles();
        return listVille;
    }

    public Ville addVille(Ville ville) throws SQLException {
        Ville villeTest = villeDAO.addVille(ville);
        return villeTest;
    }

    public void deleteVille(String codeCommune) throws SQLException{
        villeDAO.deleteVille(codeCommune);
    }

    public Ville editVille(Ville ville) throws SQLException{
        Ville ville1 = villeDAO.editVille(ville);
        return ville1;
    }
}
