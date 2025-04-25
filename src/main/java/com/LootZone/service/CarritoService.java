package com.LootZone.service;

import com.LootZone.dto.carrito.CarritoResponseDTO;

import java.util.List;

public interface CarritoService {
    List<CarritoResponseDTO> listar();
    CarritoResponseDTO buscarXID(Long id);
}
