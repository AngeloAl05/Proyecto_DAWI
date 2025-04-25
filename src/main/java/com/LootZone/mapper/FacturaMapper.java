package com.LootZone.mapper;

import com.LootZone.dto.factura.FacturaResponseDTO;
import com.LootZone.entity.Carrito;
import com.LootZone.entity.Factura;
import com.LootZone.entity.Usuario;
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
    public Factura toEntity(FacturaResponseDTO dto, Carrito carrito, Usuario usuario){
        return Factura.builder()
                .fecha(dto.getFecha())
                .total(dto.getTotal())
                .carrito(carrito)
                .usuario(usuario)
                .build();
    }
}
