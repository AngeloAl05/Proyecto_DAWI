package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {
    public CarritoResponseDTO toDTO(Carrito carrito){
        return CarritoResponseDTO.builder()
                .id_carrito(carrito.getId_carrito())
                .usuario(carrito.getUsuario())
                .build();
    }

    public Carrito toEntity(UserEntity usuario){
        return Carrito.builder()
                .usuario(usuario)
                .build();
    }
}
