package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class VilleController {

    @Autowired
    VilleBLO villeBLOService;
    public ArrayList<Ville> getInfoVilles() throws SQLException {

        System.out.println("get 2");

        ArrayList<Ville> listeVille = villeBLOService.getInfoVilles();

        return listeVille;
    }

    @PostMapping("/ville")
    public Ville addVille (@RequestBody Ville ville) throws SQLException {
        Ville ville1 = villeBLOService.addVille(ville);
        return ville1;
    }

    @DeleteMapping("/ville")
    public void deleteVille (@RequestParam(required = true, value="codeCommune") String codeCommune) throws SQLException{
        villeBLOService.deleteVille(codeCommune);
    }

    @PutMapping("/ville")
    public Ville editVille (@RequestBody Ville ville) throws SQLException{
        Ville ville1 = villeBLOService.editVille(ville);
        return ville1;
    }

}
