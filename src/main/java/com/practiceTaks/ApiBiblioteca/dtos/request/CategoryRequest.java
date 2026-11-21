package com.practiceTaks.ApiBiblioteca.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank(message = "Name of the category is required")
        @Size(max = 80)
        String name
) {
}
