package com.example.tp3.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Cd extends Document {
    private static final int EMPRUNT_CD_EN_JOURNEE = 14;
    private final String TYPE ="CD";
    private int duree;
    private String genre;

    public Cd(String titre, int datePublication, int duree, String genre, boolean disponible) {
        super(titre, datePublication,disponible);
        this.duree = duree;
        this.genre = genre;
    }
}
