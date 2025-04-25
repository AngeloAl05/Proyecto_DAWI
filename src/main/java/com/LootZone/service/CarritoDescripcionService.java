package com.LootZone.service;

import com.LootZone.dto.carrito_descripcion.CarritoDescripcionResponseDTO;

import java.util.List;

public interface CarritoDescripcionService {
    List<CarritoDescripcionResponseDTO> listar();
    CarritoDescripcionResponseDTO buscarXID(Long id);
}
