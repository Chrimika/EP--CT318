package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor  // Corrigé : 'N' en minuscule
@AllArgsConstructor
public class CategoryDTO {
    private UUID idCategory;

    @NotBlank(message = "Le nom de la catégorie est obligatoire")
    @Size(min = 2, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères")
    private String nomCategory;
}