package com.LootZone.mapper;

import com.LootZone.dto.genero.GeneroRequestDTO;
import com.LootZone.dto.genero.GeneroResponseDTO;
import com.LootZone.entity.Genero;
import org.springframework.stereotype.Component;

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
}
