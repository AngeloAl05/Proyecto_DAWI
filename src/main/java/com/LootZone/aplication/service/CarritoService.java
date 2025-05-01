package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.carrito.CarritoJuegosRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;

import java.util.List;

public interface CarritoService {
    List<CarritoResponseDTO> listar();
    CarritoResponseDTO buscarXID(Long id);
    CarritoResponseDTO editarCarritoJuegos(Long id, CarritoJuegosRequestDTO dto);
    CarritoResponseDTO crear(CarritoRequestDTO dto);
    CarritoResponseDTO buscarXUsuario(Long id);
}
