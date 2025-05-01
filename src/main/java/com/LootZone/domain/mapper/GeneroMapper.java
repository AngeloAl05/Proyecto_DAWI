package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.genero.GeneroJuegosResponseDTO;
import com.LootZone.aplication.dto.genero.GeneroRequestDTO;
import com.LootZone.aplication.dto.genero.GeneroResponseDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GeneroMapper {

    public GeneroResponseDTO toDTO(Genero genero){
        return GeneroResponseDTO.builder()
                .id_genero(genero.getId_genero())
                .nom_genero(genero.getNom_genero())
                .build();
    }
    public Genero toEntity(GeneroRequestDTO dto){
        return Genero.builder()
                .nom_genero(dto.getNom_genero())
                .build();
    }
    public GeneroJuegosResponseDTO toGeneroJuegosDto(List<JuegoResponseDTO> juegoResponseDTOS, Genero genero){
        return GeneroJuegosResponseDTO.builder()
                .id_genero(genero.getId_genero())
                .nom_genero(genero.getNom_genero())
                .juegos(new HashSet<>(juegoResponseDTOS))
                .build();
    }
}
