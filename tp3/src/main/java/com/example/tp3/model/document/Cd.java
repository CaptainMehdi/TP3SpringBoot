package com.example.tp3.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Cd extends Document {
    private static final int EMPRUNT_CD_EN_JOURNEE = 14;
    private int duree;
    private String genre;

    public Cd(String titre, int datePublication, int duree, String genre,boolean disponible) {
        super(titre, datePublication,disponible);
        this.duree = duree;
        this.genre = genre;
    }
}
