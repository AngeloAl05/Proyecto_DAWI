package com.LootZone.aplication.dto.factura;

import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FacturaResponseDTO {
    private Long id_factura;
    private LocalDate fecha;
    private double total;
    private Carrito carrito;
    private UserEntity usuario;
}
