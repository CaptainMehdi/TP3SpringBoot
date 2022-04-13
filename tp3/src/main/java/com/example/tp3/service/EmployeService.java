package com.example.tp3.service;

import com.example.tp3.model.Emprunt;
import com.example.tp3.model.document.Cd;
import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Dvd;
import com.example.tp3.model.document.Livre;
import com.example.tp3.model.personne.Client;
import com.example.tp3.model.personne.Employe;
import com.example.tp3.repository.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class EmployeService {

    private ClientRepository clientRepository;
    private LivreRepository livreRepository;
    private DvdRepository dvdRepository;
    private CdRepository cdRepository;
    private DocumentRepository documentRepository;

    public EmployeService(ClientRepository clientRepository, LivreRepository livreRepository, DvdRepository dvdRepository, CdRepository cdRepository, DocumentRepository documentRepository) {
        this.clientRepository = clientRepository;
        this.livreRepository = livreRepository;
        this.dvdRepository = dvdRepository;
        this.cdRepository = cdRepository;
        this.documentRepository = documentRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client saveClient(String nom, String prenom, String adresse) {
        return clientRepository.save(new Client(nom, prenom, adresse));
    }

    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre saveLivre(String titre, String auteur, int datePublication, String categorie, boolean dispo, String editeur, int nombrePage) {
        return livreRepository.save(new Livre(titre, auteur, datePublication, categorie, dispo, editeur, nombrePage));
    }

    public Dvd saveDvd(Dvd dvd) {
        return dvdRepository.save(dvd);
    }

    public Dvd saveDvd(String titre, String auteur, int datePublication, String categorie, boolean dispo, int duree) {
        return dvdRepository.save(new Dvd(titre, auteur, datePublication, categorie, dispo, duree));
    }

    public Cd saveCd(Cd cd) {
        return cdRepository.save(cd);
    }

    public Cd saveCd(String titre, String auteur, int datePublication, String categorie, boolean dispo, int duree) {
        return cdRepository.save(new Cd(titre, auteur, datePublication, categorie, dispo, duree));
    }

    public void createEmprunt(Client client, Document document) {
        if (!document.isDisponible()) {
            System.out.println("Le document est deja emprunte");
            return;
        }
        Emprunt emprunt = new Emprunt(LocalDate.now(), LocalDate.now().plusDays(document.getDureeEmprunt()), client, document);
        document.setDisponible(false);
        client.addEmprunt(emprunt);
    }

    public void createEmprunt(long clientId, long documentId) {
        var documentOptional = documentRepository.findById(documentId);
        var clientOptional = clientRepository.findById(clientId);

        if (documentOptional.isEmpty() || clientOptional.isEmpty()) {
            return;
        }
        var client = clientOptional.get();
        var document = documentOptional.get();

        if (!document.isDisponible()) {
            System.out.println("Le document est deja emprunte");
            return;
        }
        Emprunt emprunt = new Emprunt(LocalDate.now(), LocalDate.now().plusDays(document.getDureeEmprunt()), client, document);

        client.addEmprunt(emprunt);
        document.setDisponible(false);

    }

    public void retourDocument(Emprunt emprunt){
        LocalDate today = LocalDate.now();
        if(emprunt.getDateRetour().compareTo(today) > 0){
            long differenceEnJour = ChronoUnit.DAYS.between(emprunt.getDateRetour(),today);
            emprunt.getClient().ajoutDette(differenceEnJour);
        }
        emprunt.getDocument().setDisponible(true);
    }

    public List<Client> findAllClient(){
        return clientRepository.findAll();
    }
}
