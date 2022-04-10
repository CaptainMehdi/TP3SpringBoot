package com.example.tp3.model.document;

import com.example.tp3.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Livre extends Document {
    private static final int EMPRUNT_LIVRE_EN_JOURNEE = 21;
    private String auteur;
    private String editeur;
    private int nombrePage;
    private String genre;

    public Livre(String auteur, String editeur, int nombrePage, String genre) {
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePage = nombrePage;
        this.genre = genre;
    }
}
