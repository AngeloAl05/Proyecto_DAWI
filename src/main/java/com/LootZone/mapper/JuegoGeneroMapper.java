package com.LootZone.mapper;

import com.LootZone.dto.juego_genero.JuegoGeneroRequestDTO;
import com.LootZone.dto.juego_genero.JuegoGeneroResponseDTO;
import com.LootZone.entity.Genero;
import com.LootZone.entity.Juego;
import com.LootZone.entity.JuegoGenero;
import org.springframework.stereotype.Component;

@Component
public class JuegoGeneroMapper {
    public JuegoGeneroResponseDTO toDTO(JuegoGenero juegoGenero){
        return JuegoGeneroResponseDTO.builder()
                .id_JuegoGenero(juegoGenero.getId_JuegoGenero())
                .juego(juegoGenero.getJuego())
                .genero(juegoGenero.getGenero())
                .build();
    }

    public  JuegoGenero toEntity(Juego juego, Genero genero){
        return JuegoGenero.builder()
                .juego(juego)
                .genero(genero)
                .build();
    }

}

