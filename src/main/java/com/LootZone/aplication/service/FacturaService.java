package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.dto.juego.JuegoRequestDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaResponseDTO> listar();
    FacturaResponseDTO buscarXID(Long id);
    List<FacturaResponseDTO> buscarXUsuario(Long id);
    FacturaResponseDTO crear(FacturaRequestDTO dto);

}
