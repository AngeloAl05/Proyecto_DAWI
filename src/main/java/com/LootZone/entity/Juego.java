package com.LootZone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_juego;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String portada;
    private String trailer;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_lanzamiento;
    private int num_ventas;
    private int calificaion;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "id_desarrollador")
    private Desarrollador desarrollador;
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JuegoGenero> generos = new HashSet<>();
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CarritoDescripcion> carritoDescripcion = new HashSet<>();

}
