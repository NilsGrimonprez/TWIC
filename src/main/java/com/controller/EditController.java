package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class EditController {

    @Autowired
    VilleBLO villeBLO;

    @GetMapping("/edit")
    public String home(Model model, @RequestParam(value = "code") String code) throws IOException, SQLException {
        Ville ville = villeBLO.getInfoVille(code);
        model.addAttribute("ville", ville);
        return "/edit";
    }

    @PostMapping("/edit")
    public String editVille (@ModelAttribute("ville") Ville ville) throws SQLException{
        Ville ville1 = villeBLO.editVille(ville);
        return "/edit";
    }

    @DeleteMapping("/edit")
    public void delete(@RequestParam(value = "code") String code) throws SQLException {
        villeBLO.deleteVille(code);
    }
}