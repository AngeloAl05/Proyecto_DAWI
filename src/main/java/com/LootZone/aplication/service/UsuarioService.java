package com.LootZone.aplication.service;


import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO buscarXID(Long id);
}
