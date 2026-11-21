package com.practiceTaks.ApiBiblioteca.dtos.response;

import java.time.LocalDate;

public record AuthorResponse(
        Long id,
        String name,
        String nationality,
        LocalDate birthDate
) {
}
