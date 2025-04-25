package com.LootZone.service;

import com.LootZone.dto.genero.GeneroResponseDTO;

import java.util.List;

public interface GeneroService {
    List<GeneroResponseDTO> listar();
    GeneroResponseDTO buscarXID(Long id);
}
