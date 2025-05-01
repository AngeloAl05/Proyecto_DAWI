package com.LootZone.aplication.dto.factura;

import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
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
    private CarritoResponseDTO carrito;
    private UsuarioResponseDTO usuario;
}
