package com.LootZone.aplication.dto.carrito;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
@Data
@Builder
public class CarritoJuegosRequestDTO {
    private Set<Long> juegosAgregar;
    private Set<Long> juegosEliminar;
}
