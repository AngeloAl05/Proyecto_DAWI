package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;

import java.util.List;

public interface CarritoService {
    List<CarritoResponseDTO> listar();
    CarritoResponseDTO buscarXID(Long id);
}
