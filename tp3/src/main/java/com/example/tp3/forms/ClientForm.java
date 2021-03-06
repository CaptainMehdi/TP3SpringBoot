package com.example.tp3.forms;

import com.example.tp3.model.personne.Client;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.format.DateTimeFormatter;

@Data
public class ClientForm {
    private String id;

    @NotNull
    @NotBlank
    private String nom;

    @NotNull
    @NotBlank
    private String prenom;

    @NotNull
    @Email
    @NotBlank
    private String adresse;

    public ClientForm(String id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public ClientForm() {
        this(new Client());
    }

    public ClientForm(Client client) {
        this(Long.toString(client.getId()),
                client.getNom(),
                client.getPrenom(),
                client.getAddress());
    }

    public Client toClient() {
        final Client client = new Client(nom, prenom, adresse);
        long oldId;
        try {
            oldId = Long.parseLong(id);
            if (oldId > 0)
                client.setId(oldId);
        } catch (NumberFormatException e) {
        }

        return client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
