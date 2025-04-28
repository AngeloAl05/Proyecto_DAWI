package com.LootZone.dto.carrito;

import com.LootZone.entity.Usuario;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class CarritoResponseDTO {
    private Long id_carrito;
    private Usuario usuario;
}
