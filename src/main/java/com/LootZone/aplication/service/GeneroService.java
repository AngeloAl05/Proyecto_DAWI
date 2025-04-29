package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.genero.GeneroRequestDTO;
import com.LootZone.aplication.dto.genero.GeneroResponseDTO;

import java.util.List;

public interface GeneroService {
    List<GeneroResponseDTO> listar();
    GeneroResponseDTO crear(GeneroRequestDTO requestDTO);
    GeneroResponseDTO buscarXID(Long id);
}
