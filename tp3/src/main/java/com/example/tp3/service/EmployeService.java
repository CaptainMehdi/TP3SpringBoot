package com.example.tp3.service;

import com.example.tp3.model.personne.Client;
import com.example.tp3.repository.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeService {

    private ClientRepository clientRepository;

    public EmployeService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client saveClient(String nom, String prenom, String adresse){
        return clientRepository.save(new Client(nom,prenom,adresse));
    }
}
