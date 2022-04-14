package com.example.tp3.controller;

import com.example.tp3.forms.ClientForm;
import com.example.tp3.model.personne.Client;
import com.example.tp3.service.EmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.Optional;

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

    @GetMapping(value={ "/clientcreate"})
    public String getClientCreate(Model model) {
        var clientForm = new ClientForm();
        model.addAttribute("clientForm", clientForm);
        return "/clientEdit";
    }

    @PostMapping(value = { "/clientcreate"})
    public RedirectView clientPost(@ModelAttribute ClientForm clientForm,
                                 BindingResult errors,
                                 RedirectAttributes redirectAttributes) {
        logger.info("client: " + clientForm);
        final Client client = es.saveClient(clientForm.toClient());
        clientForm.setId(Long.toString(client.getId()));

        redirectAttributes.addFlashAttribute("clientForm", clientForm);
        redirectAttributes.addAttribute("id", clientForm.getId());

        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/clientEdit/{id}");
        return redirectView;
    }

    @GetMapping(value = { "/clientEdit/{id}"})
    public String getClientRequest(@ModelAttribute ClientForm clientForm,
                                 Model model,
                                 @PathVariable("id") String id) {
        logger.info("Into getProfRequest with id " + id);
        long clientId = getIdFromString(id);
        final Optional<Client> clientById = es.findClientById(clientId);
        clientForm = new ClientForm();
        if(clientById.isPresent()) {
            clientForm = new ClientForm(clientById.get());
        }
        model.addAttribute("clientForm", clientForm);
        return "/clientEdit";
    }

    private long getIdFromString(String id) {
        try {
            return Long.parseLong(id);
        } catch(NumberFormatException e) {}
        return 0;
    }
}
