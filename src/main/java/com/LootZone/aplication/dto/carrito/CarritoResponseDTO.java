package com.LootZone.aplication.dto.carrito;

import com.LootZone.domain.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarritoResponseDTO {
    private Long id_carrito;
    private UserEntity usuario;
}
