package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarritoMapper {
    private final UsuarioMapper usuarioMapper;
    private final JuegoMapper juegoMapper;

    public CarritoMapper(UsuarioMapper usuarioMapper, JuegoMapper juegoMapper) {
        this.usuarioMapper = usuarioMapper;
        this.juegoMapper = juegoMapper;
    }
    public CarritoResponseDTO toDTO(Carrito carrito){
        return CarritoResponseDTO.builder()
                .id_carrito(carrito.getId_carrito())
                .usuario(usuarioMapper.toDTO(carrito.getUsuario()))
                .juegos(carrito.getJuegos().stream().map(juegoMapper::toDTO).collect(Collectors.toSet()))
                .build();
    }

    public Carrito toEntity(UserEntity usuario){
        return Carrito.builder()
                .usuario(usuario)
                .build();
    }
}
