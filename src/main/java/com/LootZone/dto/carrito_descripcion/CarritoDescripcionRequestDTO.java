package com.LootZone.dto.carrito_descripcion;

import com.LootZone.entity.Carrito;
import com.LootZone.entity.Juego;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarritoDescripcionRequestDTO {
    private Long carrito;
    private Long juego;
}
