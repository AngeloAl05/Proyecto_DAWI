package com.LootZone.aplication.dto.desarrollador;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DesarrolladorResponseDTO {
    private Long id_desarrollador;
    private String nom_desarrollador;
    private String imagen;
    private String descripcion;
}
