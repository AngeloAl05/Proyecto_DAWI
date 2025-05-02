package com.LootZone.web.controller;

import com.LootZone.aplication.dto.usuario.LoginRequest;
import com.LootZone.aplication.dto.usuario.LoginResponse;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.aplication.service.IAuthService;
import com.LootZone.domain.entity.UserEntity;
import com.LootZone.domain.mapper.UsuarioMapper;
import com.LootZone.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService service;
    private final UsuarioMapper usuarioMapper;
    private final IUserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse response = service.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return ResponseEntity.ok(usuarioMapper.toDTO(user));
    }

}