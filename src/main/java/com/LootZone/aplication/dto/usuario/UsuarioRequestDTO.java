package com.LootZone.aplication.dto.usuario;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDTO {
    private String username;
    private String email;
    private String password;
    private String imagePerfil;
    private String firstName;
    private String lastName;
}
