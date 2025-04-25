package com.LootZone.dto.juego;

import com.LootZone.entity.CarritoDescripcion;
import com.LootZone.entity.Desarrollador;
import com.LootZone.entity.Genero;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
