package com.LootZone.dto.genero;

import com.LootZone.entity.Juego;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class GeneroRequestDTO {
    private String nom_genero;
}
