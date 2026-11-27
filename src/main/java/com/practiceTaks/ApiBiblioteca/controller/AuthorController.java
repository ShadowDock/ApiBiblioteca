package com.practiceTaks.ApiBiblioteca.controller;

import com.practiceTaks.ApiBiblioteca.dtos.mapper.AuthorMapper;
import com.practiceTaks.ApiBiblioteca.dtos.request.AuthorRequest;
import com.practiceTaks.ApiBiblioteca.dtos.response.AuthorResponse;
import com.practiceTaks.ApiBiblioteca.repository.AuthorRepository;
import com.practiceTaks.ApiBiblioteca.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@RequestBody @Valid AuthorRequest authorRequest) {
        AuthorResponse authorResponse = authorService.create(authorRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(authorResponse.id())
                .toUri();

        return ResponseEntity.created(location).body(authorResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long id,
                                                 @RequestBody @Valid AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.update(id, authorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
