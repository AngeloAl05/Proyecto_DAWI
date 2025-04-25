package com.LootZone.service;

import com.LootZone.dto.desarrollador.DesarrolladorResponseDTO;

import java.util.List;

public interface DesarrolladorService {
    List<DesarrolladorResponseDTO> listar();
    DesarrolladorResponseDTO buscarXID(Long id);
}
