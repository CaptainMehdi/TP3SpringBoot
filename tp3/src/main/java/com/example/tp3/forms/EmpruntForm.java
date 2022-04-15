package com.example.tp3.forms;

import com.example.tp3.model.Emprunt;
import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Livre;
import com.example.tp3.model.personne.Client;
import com.example.tp3.repository.ClientRepository;
import com.example.tp3.repository.DocumentRepository;
import com.example.tp3.repository.LivreRepository;
import com.example.tp3.service.EmployeService;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import java.time.format.DateTimeFormatter;


@Data
public class EmpruntForm {
    private static DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String id;
    @NotNull
    private String dateEmprunt;

    private String dateRetour;

    @NotNull
    private int clientId;

    @NotNull
    private int livreId;

    private Client client;
    private Document document;

    public EmpruntForm(String id, String dateEmprunt, int clientId, int livreId) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.clientId = clientId;
        this.livreId = livreId;
    }

    public EmpruntForm() {
    }

    public EmpruntForm(Emprunt emprunt) {
        this(Long.toString(emprunt.getId()),
                emprunt.getDateEmprunt() == null ? null : DATETIMEFORMATTER.format(emprunt.getDateEmprunt()),
                (int) emprunt.getClient().getId(),
                (int) emprunt.getDocument().getId());
    }


}
