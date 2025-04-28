package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.juego.JuegoResponseDTO;

import java.util.List;

public interface JuegoService {
    List<JuegoResponseDTO> listar();
    JuegoResponseDTO buscarXID(Long id);
}
