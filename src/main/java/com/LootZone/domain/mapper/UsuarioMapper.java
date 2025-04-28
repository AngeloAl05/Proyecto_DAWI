package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDTO toDTO(Usuario usuario){
        return UsuarioResponseDTO.builder()
                .id_usuario(usuario.getId_usuario())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .imagePerfil(usuario.getImagePerfil())
                .firstName(usuario.getFirstName())
                .lastName(usuario.getLastName())
                .build();
    }

    public Usuario toEntity(UsuarioRequestDTO dto){
        return Usuario.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .imagePerfil(dto.getImagePerfil())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

    }
}
