package com.LootZone.service;


import com.LootZone.dto.usuario.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO buscarXID(Long id);
}
