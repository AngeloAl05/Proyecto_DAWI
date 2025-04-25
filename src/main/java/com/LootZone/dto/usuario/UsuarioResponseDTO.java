package com.LootZone.dto.usuario;

import com.LootZone.entity.Carrito;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class UsuarioResponseDTO {
    private Long id_usuario;
    private String username;
    private String email;
    private String imagePerfil;
    private String firstName;
    private String lastName;
}
