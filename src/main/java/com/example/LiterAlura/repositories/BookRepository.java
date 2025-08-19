package com.example.LiterAlura.repositories;

import com.example.LiterAlura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // aqui você pode adicionar consultas customizadas depois, exemplo:
    // List<Book> findByTitleContainingIgnoreCase(String title);
}