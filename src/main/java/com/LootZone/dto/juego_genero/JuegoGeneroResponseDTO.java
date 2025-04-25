package com.LootZone.dto.juego_genero;

import com.LootZone.entity.Genero;
import com.LootZone.entity.Juego;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JuegoGeneroResponseDTO {
    private Long id_JuegoGenero;
    private Juego juego;
    private Genero genero;
}
