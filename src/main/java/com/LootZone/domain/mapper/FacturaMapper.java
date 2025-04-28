package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.Factura;
import com.LootZone.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class FacturaMapper {
    public FacturaResponseDTO toDTO(Factura factura){
        return FacturaResponseDTO.builder()
                .id_factura(factura.getId_factura())
                .fecha(factura.getFecha())
                .total(factura.getTotal())
                .carrito(factura.getCarrito())
                .usuario(factura.getUsuario())
                .build();
    }
    public Factura toEntity(FacturaResponseDTO dto, Carrito carrito, UserEntity usuario){
        return Factura.builder()
                .fecha(dto.getFecha())
                .total(dto.getTotal())
                .carrito(carrito)
                .usuario(usuario)
                .build();
    }
}
