package com.practiceTaks.ApiBiblioteca.repository;

import com.practiceTaks.ApiBiblioteca.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {

}
