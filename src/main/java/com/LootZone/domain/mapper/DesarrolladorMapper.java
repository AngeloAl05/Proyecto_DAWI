package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.desarrollador.DesarrolladorRequestDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorResponseDTO;
import com.LootZone.domain.entity.Desarrollador;
import org.springframework.stereotype.Component;

@Component
public class DesarrolladorMapper {
    public DesarrolladorResponseDTO toDTO(Desarrollador desarrollador){
        return DesarrolladorResponseDTO.builder()
                .id_desarrollador(desarrollador.getId_desarrollador())
                .nom_desarrollador(desarrollador.getNom_desarrollador())
                .imagen(desarrollador.getImagen())
                .descripcion(desarrollador.getDescripcion())
                .build();
    }
    public Desarrollador toEntity(DesarrolladorRequestDTO dto){
        return Desarrollador.builder()
                .nom_desarrollador(dto.getNom_desarrollador())
                .imagen(dto.getImagen())
                .descripcion(dto.getDescripcion())
                .build();
    }
}
