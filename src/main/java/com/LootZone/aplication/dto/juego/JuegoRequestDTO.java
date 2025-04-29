package com.LootZone.aplication.dto.juego;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class JuegoRequestDTO {
    private String titulo;
    private String descripcion;
    private String imagen;
    private String portada;
    private String trailer;
    private LocalDate fecha_lanzamiento;
    private int num_ventas;
    private int calificaion;
    private double precio;
    private Long desarrollador;
    private Set<Long> generos;
}
