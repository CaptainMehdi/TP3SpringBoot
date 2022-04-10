package com.example.tp3.model.personne;

import com.example.tp3.model.personne.Personne;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Client extends Personne {
    private double dette = 0;

    public Client(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

}
