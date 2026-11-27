package com.practiceTaks.ApiBiblioteca.service;

import com.practiceTaks.ApiBiblioteca.domain.Author;
import com.practiceTaks.ApiBiblioteca.dtos.mapper.AuthorMapper;
import com.practiceTaks.ApiBiblioteca.dtos.request.AuthorRequest;
import com.practiceTaks.ApiBiblioteca.dtos.response.AuthorResponse;
import com.practiceTaks.ApiBiblioteca.exception.ResourceNotFoundException;
import com.practiceTaks.ApiBiblioteca.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorResponse> findAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toResponse)
                .toList();
    }

    public AuthorResponse findById(Long id) {
        Author author = findAuthorOrThrow(id);
        return authorMapper.toResponse(author);
    }
    @Transactional
    public AuthorResponse create(AuthorRequest authorRequest) {
        Author author = authorMapper.toEntity(authorRequest);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toResponse(savedAuthor);
    }
    @Transactional
    public AuthorResponse update(Long id, AuthorRequest authorRequest) {
        Author author = findAuthorOrThrow(id);
        authorMapper.update(author, authorRequest);
        return authorMapper.toResponse(author);
    }
    @Transactional
    public void deleteById(Long id) {
        Author author = findAuthorOrThrow(id);
        authorRepository.delete(author);
    }

    public Author findAuthorOrThrow(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

}
