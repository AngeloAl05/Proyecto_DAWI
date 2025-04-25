package com.LootZone.mapper;

import com.LootZone.dto.carrito_descripcion.CarritoDescripcionResponseDTO;
import com.LootZone.entity.Carrito;
import com.LootZone.entity.CarritoDescripcion;
import com.LootZone.entity.Juego;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class CarritoDescripcionMapper {
    public CarritoDescripcionResponseDTO toDTO(CarritoDescripcion carritoDescripcion){
        return CarritoDescripcionResponseDTO.builder()
                .idCarDes(carritoDescripcion.getIdCarDes())
                .carrito(carritoDescripcion.getCarrito())
                .juego(carritoDescripcion.getJuego())
                .build();
    }

    public CarritoDescripcion toEntity(Carrito carrito, Juego juego){
        return CarritoDescripcion.builder()
                .carrito(carrito)
                .juego(juego)
                .build();
    }

}
