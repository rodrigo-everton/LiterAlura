package com.example.LiterAlura.repositories;

import com.example.LiterAlura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // consultas customizadas
    // List<Author> findByBirthYearGreaterThan(Integer year);
}
