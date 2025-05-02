package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.desarrollador.DesarrolladorJuegoResponseDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorRequestDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorResponseDTO;

import java.util.List;

public interface DesarrolladorService {
    List<DesarrolladorResponseDTO> listar();
    DesarrolladorJuegoResponseDTO buscarXID(Long id);
    DesarrolladorResponseDTO crear(DesarrolladorRequestDTO dto);
}
