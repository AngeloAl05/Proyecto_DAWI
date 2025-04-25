package com.LootZone.service;

import com.LootZone.dto.factura.FacturaResponseDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaResponseDTO> listar();
    FacturaResponseDTO buscarXID(Long id);
}
