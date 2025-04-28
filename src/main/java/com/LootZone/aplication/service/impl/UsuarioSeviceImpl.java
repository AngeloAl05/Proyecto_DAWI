package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.aplication.service.UsuarioService;
import com.LootZone.domain.entity.UserEntity;
import com.LootZone.domain.mapper.UsuarioMapper;
import com.LootZone.domain.repository.IUserRepository;
import com.LootZone.security.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioSeviceImpl implements UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioResponseDTO> listar() {
        return userRepository.findAll().stream().map(usuarioMapper::toDTO).toList();
    }

    @Override
    public UsuarioResponseDTO crear(UsuarioRequestDTO requestDTO) {
        String encryptedPassword = passwordEncoder.encode(requestDTO.getPassword());

        UserEntity usuario = usuarioMapper.toEntity(requestDTO);
        usuario.setPassword(encryptedPassword);

        UserEntity nuevoUsuario = userRepository.save(usuario);

        UsuarioResponseDTO responseDTO = usuarioMapper.toDTO(nuevoUsuario);

        return responseDTO;
    }

    @Override
    public UsuarioResponseDTO buscarXID(Long id) {
        return userRepository.findById(id)
                .map(usuarioMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("No existe el usuario con ID: " + id));
    }
}
