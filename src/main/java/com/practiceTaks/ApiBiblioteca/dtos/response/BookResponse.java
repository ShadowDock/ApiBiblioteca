package com.practiceTaks.ApiBiblioteca.dtos.response;

import java.util.Set;

public record BookResponse(
        Long id,
        String title,
        String isbn,
        Integer publishedYear,
        String authorName,
        Set<String> categories
) {
}
