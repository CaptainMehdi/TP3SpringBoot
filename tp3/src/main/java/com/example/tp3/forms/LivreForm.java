package com.example.tp3.forms;

import com.example.tp3.model.document.Livre;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LivreForm {
    private String id;
    private String titre;
    private String auteur;
    private int datePublication;
    private String categorie;
    private boolean disponible;
    private String editeur;
    private int nombrePage;

    public LivreForm(String id, String titre, String auteur, int datePublication, String categorie, boolean disponible, String editeur, int nombrePage) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.categorie = categorie;
        this.disponible = disponible;
        this.editeur = editeur;
        this.nombrePage = nombrePage;
    }

    public LivreForm() {
        this(new Livre());
    }

    public LivreForm(Livre livre) {
        this(Long.toString(livre.getId()),
                livre.getTitre(),
                livre.getAuteur(),
                livre.getDatePublication(),
                livre.getCategorie(),
                livre.isDisponible(),
                livre.getEditeur(),
                livre.getNombrePage());
    }

    public Livre toLivre() {
        final Livre livre = new Livre(titre, auteur, datePublication, categorie, disponible, editeur, nombrePage);
        long oldId;
        try {
            oldId = Long.parseLong(id);
            if (oldId > 0)
                livre.setId(oldId);
        } catch (NumberFormatException e) {
        }

        return livre;
    }
}

