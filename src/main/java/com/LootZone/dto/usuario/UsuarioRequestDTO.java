package com.LootZone.dto.usuario;

import com.LootZone.entity.Carrito;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDTO {
    private String username;
    private String email;
    private String imagePerfil;
    private String firstName;
    private String lastName;
}
