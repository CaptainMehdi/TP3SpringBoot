package com.example.tp3;

import com.example.tp3.model.personne.Client;
import com.example.tp3.repository.ClientRepository;
import com.example.tp3.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Tp3Application implements CommandLineRunner {

    @Autowired
    private EmployeService es;

    @Autowired
    private ClientRepository clientRepository;


    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final Client client = es.saveClient("mehdi","popo","39 rue monge");

        System.out.println(clientRepository.findClientByNom("mehdi"));
    }
}
