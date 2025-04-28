package com.LootZone.domain.entity;

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
public class Desarrollador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_desarrollador;
    private String nom_desarrollador;
    private String imagen;
    private String descripcion;
    @OneToMany(mappedBy = "desarrollador")
    private Set<Juego> juegos = new HashSet<>();
}
