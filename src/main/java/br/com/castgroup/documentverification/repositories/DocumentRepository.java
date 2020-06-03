package br.com.castgroup.documentverification.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.castgroup.documentverification.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> { }


