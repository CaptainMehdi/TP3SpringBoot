package com.example.tp3.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private LocalDate datePublication;
    private int dureeEmprunt;
    private boolean disponible = true;

    public Document(String titre, int datePublication, boolean disponible) {
        this.titre = titre;
        this.datePublication = datePublication;
        this.disponible = disponible;
    }
}
