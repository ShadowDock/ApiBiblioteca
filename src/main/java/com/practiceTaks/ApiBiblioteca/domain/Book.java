package com.practiceTaks.ApiBiblioteca.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private Integer publishedYear;

    @ManyToOne(fetch = FetchType.LAZY) //Muitos livros para um autor(LAZY = só busca o autor no banco quando você chamar book.getAuthor())
    @JoinColumn(name = "author_id") // diz qual coluna do banco guarda o id do autor
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}
