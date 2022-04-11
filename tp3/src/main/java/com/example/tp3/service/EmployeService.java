package com.example.tp3.service;

import com.example.tp3.model.document.Cd;
import com.example.tp3.model.document.Dvd;
import com.example.tp3.model.document.Livre;
import com.example.tp3.model.personne.Client;
import com.example.tp3.model.personne.Employe;
import com.example.tp3.repository.CdRepository;
import com.example.tp3.repository.ClientRepository;
import com.example.tp3.repository.DvdRepository;
import com.example.tp3.repository.LivreRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeService {

    private ClientRepository clientRepository;
    private LivreRepository livreRepository;
    private DvdRepository dvdRepository;
    private CdRepository cdRepository;

    public EmployeService(ClientRepository clientRepository, LivreRepository livreRepository, DvdRepository dvdRepository, CdRepository cdRepository) {
        this.clientRepository = clientRepository;
        this.livreRepository = livreRepository;
        this.dvdRepository = dvdRepository;
        this.cdRepository = cdRepository;
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

    public Livre saveLivre(String titre, int datePublication, String auteur, String editeur, int nombrePage, String genre) {
        return livreRepository.save(new Livre(titre, datePublication, auteur, editeur, nombrePage, genre));
    }

    public Dvd saveDvd(Dvd dvd) {
        return dvdRepository.save(dvd);
    }

    public Dvd saveDvd(String titre, int datePublication, int duree, String genre) {
        return dvdRepository.save(new Dvd(titre, datePublication, duree, genre));
    }

    public Cd saveCd(Cd cd){
        return cdRepository.save(cd);
    }
    public Cd saveCd(String titre, int datePublication, int duree, String genre){
        return cdRepository.save(new Cd(titre,datePublication,duree,genre));
    }



}
