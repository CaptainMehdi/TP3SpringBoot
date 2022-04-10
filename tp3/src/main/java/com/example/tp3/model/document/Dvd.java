package com.example.tp3.model.document;

import com.example.tp3.model.document.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Dvd extends Document {
    private static final int EMPRUNT_DVD_EN_JOURNEE = 7;
    private int duree;
    private String genre;

    public Dvd(int duree, String genre) {
        this.duree = duree;
        this.genre = genre;
    }
}