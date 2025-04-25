package com.LootZone.service;

import com.LootZone.dto.juego_genero.JuegoGeneroResponseDTO;

import java.util.List;

public interface JuegoGeneroService {
    List<JuegoGeneroResponseDTO> listar();
    JuegoGeneroResponseDTO buscarXID(Long id);
}
