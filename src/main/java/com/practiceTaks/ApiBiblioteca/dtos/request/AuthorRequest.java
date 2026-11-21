package com.practiceTaks.ApiBiblioteca.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AuthorRequest(
        @NotBlank(message = "Name is required")
        @Size(max = 150)
        String name,

        @Size(max = 80)
        String nationality,

        @Past
        LocalDate birthDate
) {
}
