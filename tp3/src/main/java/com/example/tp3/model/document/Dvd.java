package com.example.tp3.model.document;

import com.example.tp3.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Dvd extends Document {
    private static final int EMPRUNT_DVD_EN_JOURNEE = 7;
    private final String TYPE ="DVD";
    private int duree;
    private String genre;

    public Dvd(String titre, int datePublication, int duree, String genre, boolean disponible) {
        super(titre, datePublication,disponible);
        this.duree = duree;
        this.genre = genre;
    }
}
