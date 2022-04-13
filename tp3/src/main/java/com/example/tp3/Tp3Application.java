package com.example.tp3;

import com.example.tp3.model.document.Cd;
import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Livre;
import com.example.tp3.model.personne.Client;
import com.example.tp3.repository.ClientRepository;
import com.example.tp3.repository.DocumentRepository;
import com.example.tp3.repository.LivreRepository;
import com.example.tp3.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class Tp3Application implements CommandLineRunner {

    @Autowired
    private EmployeService es;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private DocumentRepository documentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final Client client = es.saveClient("mehdi", "popo", "39 rue monge");
        final Client client1 = es.saveClient("teo", "dort", "48 rue louge");
        final Livre livre = es.saveLivre("ded", 2002, "gira", "por", 202, "action", true);
        final Cd cd = es.saveCd("Mine", 2005, 20, "Action", true);

        es.createEmprunt(client, livre);

        es.createEmprunt(client.getId(), livre.getId());

        System.out.println(clientRepository.findClientByNom("mehdi"));
        System.out.println(livreRepository.findById(2L));

    }
}
