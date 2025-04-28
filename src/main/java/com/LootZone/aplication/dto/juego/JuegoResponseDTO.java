package com.LootZone.aplication.dto.juego;


import com.LootZone.domain.entity.Desarrollador;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class JuegoResponseDTO {
    private Long id_juego;
    private String titulo;
    private String descripcion;
    private String imagen;
    private String portada;
    private String trailer;
    private LocalDate fecha_lanzamiento;
    private int num_ventas;
    private int calificaion;
    private double precio;
    private Desarrollador desarrollador;
}
