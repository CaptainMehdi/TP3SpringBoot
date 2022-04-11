package com.example.tp3.model.personne;

import com.example.tp3.model.Emprunt;
import com.example.tp3.model.personne.Personne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client extends Personne {
    @OneToMany
    @ToString.Exclude
    List<Emprunt> listEmprunt = new ArrayList<>();
    private double dette = 0.0;

    public Client(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

    @Override
    public String toString() {
        return "Client{" +super.toString()+
                "dette=" + dette +
                '}';
    }
}
