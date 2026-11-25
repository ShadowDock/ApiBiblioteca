package com.practiceTaks.ApiBiblioteca.dtos.mapper;

import com.practiceTaks.ApiBiblioteca.domain.Author;
import com.practiceTaks.ApiBiblioteca.dtos.request.AuthorRequest;
import com.practiceTaks.ApiBiblioteca.dtos.response.AuthorResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    // Request -> Entity (usado no cadastro)
    public Author toEntity(AuthorRequest authorRequest) {
        Author author = new Author();
        author.setName(authorRequest.name());
        author.setNationality((authorRequest.nationality()));
        author.setBirthDate(authorRequest.birthDate());
        return author;
    }

    // Entity -> Response (usado em toda resposta da API)
    public AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getNationality(),
                author.getBirthDate()
        );
    }

    // Atualiza uma entidade que já existe (usado no PUT)
    public void update(Author author, AuthorRequest authorRequest) {
        author.setName(authorRequest.name());
        author.setNationality(authorRequest.nationality());
        author.setBirthDate(authorRequest.birthDate());
    }
}
