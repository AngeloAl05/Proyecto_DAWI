package com.LootZone.domain.mapper;

import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDTO toDTO(UserEntity usuario){
        return UsuarioResponseDTO.builder()
                .id_usuario(usuario.getId())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .imagePerfil(usuario.getImagePerfil())
                .firstName(usuario.getFirstName())
                .lastName(usuario.getLastName())
                .build();
    }

    public UserEntity toEntity(UsuarioRequestDTO dto){
        return UserEntity.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .imagePerfil(dto.getImagePerfil())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

    }
}
