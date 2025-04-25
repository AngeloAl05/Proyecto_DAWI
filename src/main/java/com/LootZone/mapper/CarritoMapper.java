package com.LootZone.mapper;

import com.LootZone.dto.carrito.CarritoRequestDTO;
import com.LootZone.dto.carrito.CarritoResponseDTO;
import com.LootZone.entity.Carrito;
import com.LootZone.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {
    public CarritoResponseDTO toDTO(Carrito carrito){
        return CarritoResponseDTO.builder()
                .id_carrito(carrito.getId_carrito())
                .usuario(carrito.getUsuario())
                .build();
    }

    public Carrito toEntity(Usuario usuario){
        return Carrito.builder()
                .usuario(usuario)
                .build();
    }
}
