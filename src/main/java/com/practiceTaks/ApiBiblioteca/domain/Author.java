package com.practiceTaks.ApiBiblioteca.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
