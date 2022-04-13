package com.example.tp3.service;

import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Livre;
import com.example.tp3.repository.*;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientService {
    private ClientRepository clientRepository;
    private LivreRepository livreRepository;
    private DvdRepository dvdRepository;
    private CdRepository cdRepository;
    private DocumentRepository documentRepository;

    public ClientService(ClientRepository clientRepository, LivreRepository livreRepository, DvdRepository dvdRepository, CdRepository cdRepository, DocumentRepository documentRepository) {
        this.clientRepository = clientRepository;
        this.livreRepository = livreRepository;
        this.dvdRepository = dvdRepository;
        this.cdRepository = cdRepository;
        this.documentRepository = documentRepository;
    }

    public List<Document> getDocumentByTitre(String titre){
        return documentRepository.getDocumentByTitre(titre);
    }

    public List<Document> getDocumentByAuteur(String auteur){
        return documentRepository.getDocumentByAuteur(auteur);
    }

    public List<Document> getDocumentByDatePublication(int annee){
        return documentRepository.getDocumentByDatePublication(annee);
    }

    public List<Document> getDocumentByCategorie(String categorie){
        return documentRepository.getDocumentByCategorie(categorie);
    }
}
