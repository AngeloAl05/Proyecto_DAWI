package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaResponseDTO> listar();
    FacturaResponseDTO buscarXID(Long id);
    FacturaResponseDTO crear(FacturaRequestDTO requestDTO);

}
