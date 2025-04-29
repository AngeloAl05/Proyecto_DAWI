package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.desarrollador.DesarrolladorRequestDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorResponseDTO;

import java.util.List;

public interface DesarrolladorService {
    List<DesarrolladorResponseDTO> listar();
    DesarrolladorResponseDTO buscarXID(Long id);
    DesarrolladorResponseDTO crear(DesarrolladorRequestDTO dto);
}
