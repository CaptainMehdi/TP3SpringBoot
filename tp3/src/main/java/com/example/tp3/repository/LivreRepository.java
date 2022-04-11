package com.example.tp3.repository;

import com.example.tp3.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    Livre findById(long id);
}
