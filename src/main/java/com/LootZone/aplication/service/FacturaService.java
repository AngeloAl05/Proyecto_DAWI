package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaResponseDTO> listar();
    FacturaResponseDTO buscarXID(Long id);
    List<FacturaResponseDTO> buscarXUsuario(Long id);
    FacturaResponseDTO crear(FacturaRequestDTO dto);

}
