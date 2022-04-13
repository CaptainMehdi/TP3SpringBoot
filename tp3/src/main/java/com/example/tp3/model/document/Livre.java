package com.example.tp3.model.document;

import com.example.tp3.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Livre extends Document {
    private static final int EMPRUNT_LIVRE_EN_JOURNEE = 21;
    private final String TYPE ="LIVRE";
    private String auteur;
    private String editeur;
    private int nombrePage;
    private String genre;

    public Livre(String titre, int datePublication, String auteur, String editeur, int nombrePage, String genre, boolean disponible) {
        super(titre, datePublication,disponible);
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePage = nombrePage;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Livre{" +super.toString()+
                "auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", nombrePage=" + nombrePage +
                ", genre='" + genre + '\'' +
                '}';
    }
}
