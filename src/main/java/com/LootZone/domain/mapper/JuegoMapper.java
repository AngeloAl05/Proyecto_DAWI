package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.juego.JuegoRequestDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.domain.entity.Desarrollador;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JuegoMapper {
    private final GeneroMapper generoMapper;

    public JuegoMapper(GeneroMapper generoMapper) {
        this.generoMapper = generoMapper;
    }

    public JuegoResponseDTO toDTO(Juego juego){
        return JuegoResponseDTO.builder()
                .id_juego(juego.getId_juego())
                .titulo(juego.getTitulo())
                .descripcion(juego.getDescripcion())
                .imagen(juego.getImagen())
                .portada(juego.getPortada())
                .trailer(juego.getTrailer())
                .fecha_lanzamiento(juego.getFecha_lanzamiento())
                .num_ventas(juego.getNum_ventas())
                .calificaion(juego.getCalificaion())
                .precio(juego.getPrecio())
                .desarrollador(juego.getDesarrollador())
                .generos(juego.getGeneros().stream().map(generoMapper::toDTO).collect(Collectors.toSet()))
                .build();
    }
    public Juego toEntity(JuegoRequestDTO dto, Desarrollador desarrollador, Set<Genero> generos){
        return Juego.builder()
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .imagen(dto.getImagen())
                .portada(dto.getPortada())
                .trailer(dto.getTrailer())
                .fecha_lanzamiento(dto.getFecha_lanzamiento())
                .num_ventas(dto.getNum_ventas())
                .calificaion(dto.getCalificaion())
                .precio(dto.getPrecio())
                .desarrollador(desarrollador)
                .generos(generos)
                .build();
    }
}
