package com.LootZone.dto.carrito;

import com.LootZone.entity.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarritoRequestDTO {
    private Long usuario;
}
