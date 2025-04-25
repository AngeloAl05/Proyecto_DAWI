package com.LootZone.dto.genero;

import com.LootZone.entity.Juego;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class GeneroResponseDTO {
    private Long id_genero;
    private String nom_genero;
}
