package com.LootZone.aplication.dto.desarrollador;

import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class DesarrolladorJuegoResponseDTO {
    private Long id_desarrollador;
    private String nom_desarrollador;
    private String imagen;
    private String descripcion;
    private Set<JuegoResponseDTO> juegos;
}
