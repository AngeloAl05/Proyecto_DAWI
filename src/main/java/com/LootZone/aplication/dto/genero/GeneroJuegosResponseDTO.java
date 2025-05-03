package com.LootZone.aplication.dto.genero;

import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class GeneroJuegosResponseDTO {
    private Long id_genero;
    private String nom_genero;
    private String imagen;
    private Set<JuegoResponseDTO> juegos;
}
