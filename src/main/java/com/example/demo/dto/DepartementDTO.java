package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartementDTO {
    private UUID idDepartement;

    @NotBlank(message = "Le nom du département est obligatoire")
    @Size(min = 2, max = 50)
    private String nomDepartement;
}