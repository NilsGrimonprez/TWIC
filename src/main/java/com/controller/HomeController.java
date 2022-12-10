package com.controller;

import com.blo.VilleBLO;
import com.blo.VilleBLOImpl;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    VilleBLO villeBLO;

    @GetMapping("/ville")
    public String home(Model model) throws IOException, SQLException {
        List<Ville> villes = villeBLO.getInfoVilles("1");
        model.addAttribute("villes", villes);
        return "/home";
    }

}
