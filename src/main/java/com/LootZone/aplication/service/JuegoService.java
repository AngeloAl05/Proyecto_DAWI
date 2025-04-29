package com.LootZone.aplication.service;

import com.LootZone.aplication.dto.juego.JuegoRequestDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;

import java.util.List;

public interface JuegoService {
    List<JuegoResponseDTO> listar();
    JuegoResponseDTO buscarXID(Long id);
    JuegoResponseDTO crear(JuegoRequestDTO dto);
    JuegoResponseDTO editarJuego(Long id_juego, JuegoRequestDTO dto);
}
