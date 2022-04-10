package com.example.tp3.model.document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private int datePublication;

    public Document(int id, String titre, int datePublication) {
        this.id = id;
        this.titre = titre;
        this.datePublication = datePublication;
    }
}
