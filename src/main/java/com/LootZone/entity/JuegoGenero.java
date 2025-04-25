package com.LootZone.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuegoGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_JuegoGenero;
    @ManyToOne
    @JoinColumn(name = "generos")
    private Juego juego;
    @ManyToOne
    @JoinColumn(name = "juegos")
    private Genero genero;
}
