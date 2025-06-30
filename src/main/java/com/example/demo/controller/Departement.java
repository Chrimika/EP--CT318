package com.example.demo.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Departement {

    @Id
    private String id;

    private String nom;
}
