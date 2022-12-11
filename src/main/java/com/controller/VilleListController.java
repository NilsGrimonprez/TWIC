package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VilleListController {

    @Autowired
    VilleBLO villeBLO;

    @GetMapping("/villes")
    public String home(Model model, @RequestParam(value = "numero", required = false, defaultValue = "1") int numero) throws IOException, SQLException {
        List<Ville> villes = villeBLO.getInfoVilles();
        List<Ville> villes2 = new ArrayList<>();
        if((numero-1)*50>villes.size()){
            numero -= 1;
        }
        for (int i=(numero-1)*50; i<numero*50; i++){
            if(i>=villes.size()){
                break;
            }
            villes2.add(villes.get(i));
        }
        Ville v = villes.get(numero - 1);
        model.addAttribute("ville", villes2);
        model.addAttribute("numero", numero);
        return "/villesList";
    }
}