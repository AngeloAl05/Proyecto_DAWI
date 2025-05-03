package com.LootZone.aplication.dto.genero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneroRequestDTO {
    private String nom_genero;
    private String imagen;
}
