package com.example.tp3.forms;

import com.example.tp3.model.document.Livre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class LivreForm {
    private String id;

    @NotNull
    @NotBlank
    private String titre;

    @NotNull
    @NotBlank
    private String auteur;

    @NotNull
    private int datePublication;

    @NotNull
    @NotBlank
    private String categorie;

    private boolean disponible;

    @NotNull
    @NotBlank
    private String editeur;

    @NotNull
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

