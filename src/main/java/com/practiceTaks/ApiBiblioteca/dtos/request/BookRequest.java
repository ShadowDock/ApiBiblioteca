package com.practiceTaks.ApiBiblioteca.dtos.request;

import jakarta.validation.constraints.*;

import java.util.Set;

public record BookRequest(

        @NotBlank(message = "Title is required")
        @Size(max = 200)
        String title,

        @NotBlank(message = "ISBN is required")
        @Size(max = 20)
        String isbn,

        @Min(1000)
        @Max(2100)
        Integer publishedYear,

        @NotNull(message = "Author id is required")
        Long authorId,

        @NotEmpty(message = "A least one category is required")
        Set<Long> categoryId



) {
}
