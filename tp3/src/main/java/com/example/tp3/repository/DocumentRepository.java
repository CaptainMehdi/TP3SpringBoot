package com.example.tp3.repository;

import com.example.tp3.model.document.Document;
import com.example.tp3.model.document.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document,Long> {
    Optional<Document> findById(Long id);
}
