package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.domain.entity.UserEntity;

import java.util.List;

public interface FacturaService {
    List<FacturaResponseDTO> listar(String username);
    FacturaResponseDTO buscarXID(Long id);
    FacturaResponseDTO crear(String username, FacturaRequestDTO dto);
}
