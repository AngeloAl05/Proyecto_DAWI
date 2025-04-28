package com.LootZone.aplication.dto.desarrollador;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DesarrolladorRequestDTO {
    private String nom_desarrollador;
    private String imagen;
    private String descripcion;
}
