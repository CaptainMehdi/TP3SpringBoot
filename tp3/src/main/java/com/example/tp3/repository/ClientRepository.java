package com.example.tp3.repository;

import com.example.tp3.model.personne.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findClientByNom(String nom );
}
