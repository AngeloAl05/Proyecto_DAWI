package com.LootZone.dto.factura;

import com.LootZone.entity.Carrito;
import com.LootZone.entity.Usuario;
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
    private Usuario usuario;
}
