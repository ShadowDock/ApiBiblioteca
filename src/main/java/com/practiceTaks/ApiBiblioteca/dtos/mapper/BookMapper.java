package com.practiceTaks.ApiBiblioteca.dtos.mapper;

import com.practiceTaks.ApiBiblioteca.domain.Book;
import com.practiceTaks.ApiBiblioteca.domain.Category;
import com.practiceTaks.ApiBiblioteca.dtos.request.BookRequest;
import com.practiceTaks.ApiBiblioteca.dtos.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book toEntity(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.title());
        book.setIsbn(bookRequest.isbn());
        book.setPublishedYear(bookRequest.publishedYear());
        return book;
    }

    public BookResponse toResponse(Book book) {
        Set<String> categoryNames = book.getCategories().stream()
                .map(Category::getName)
                .collect(Collectors.toSet());

        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getIsbn(),
                book.getPublishedYear(),
                book.getAuthor().getName(),
                categoryNames
        );
    }

    public void updateBook(Book book, BookRequest bookRequest) {
        book.setTitle(bookRequest.title());
        book.setIsbn(bookRequest.isbn());
        book.setPublishedYear(bookRequest.publishedYear());
    }
}
