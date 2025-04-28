package com.LootZone.aplication.dto.usuario;

import lombok.Builder;
import lombok.Data;

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
