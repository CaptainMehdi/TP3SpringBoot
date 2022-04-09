package com.example.tp3.service;

import com.example.tp3.repository.*;

public class EmployeService {
    private final DocumentRepository documentRepository;
    private final LivreRepository livreRepository;
    private final CdRepository cdRepository;
    private final DvdRepository dvdRepository;
    private final ClientRepository clientRepository;
    private final EmpruntRepository empruntRepository;

    public EmployeService(DocumentRepository documentRepository, LivreRepository livreRepository, CdRepository cdRepository, DvdRepository dvdRepository, ClientRepository clientRepository, EmpruntRepository empruntRepository) {
        this.documentRepository = documentRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
        this.clientRepository = clientRepository;
        this.empruntRepository = empruntRepository;
    }
}
