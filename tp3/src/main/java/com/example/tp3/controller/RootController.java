package com.example.tp3.controller;

import com.example.tp3.service.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    Logger logger = LoggerFactory.getLogger(RootController.class);

    private EmployeService es;

    public RootController(EmployeService es) {
        this.es = es;
    }

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle", "Accueil");
        model.addAttribute("h1Text", "La bibliotheque");
        return "index";
    }

    @GetMapping("/clients")
    public String getClient(Model model) {
        model.addAttribute("pageTitle", "Mon demo");
        var clients = es.findAllClient();
        model.addAttribute("clients", clients);
        return "clients";
    }
}
