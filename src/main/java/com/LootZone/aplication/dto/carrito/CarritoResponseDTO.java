package com.LootZone.aplication.dto.carrito;

import com.LootZone.aplication.dto.genero.GeneroResponseDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.domain.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CarritoResponseDTO {
    private Long id_carrito;
    private UsuarioResponseDTO usuario;
    private Set<JuegoResponseDTO> juegos;
}
