package com.LootZone.aplication.dto.genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneroResponseDTO {
    private Long id_genero;
    private String nom_genero;
}
