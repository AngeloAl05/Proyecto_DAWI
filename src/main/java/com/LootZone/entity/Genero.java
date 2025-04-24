package com.LootZone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;
    private String nom_genero;
    @ManyToMany(mappedBy = "generos")
    private Set<Juego> juegos = new HashSet<>();
}
