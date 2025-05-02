package com.LootZone.web.controller;

import com.LootZone.aplication.dto.carrito.CarritoJuegosRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.CarritoService;
import com.LootZone.aplication.service.UsuarioService;
import com.LootZone.aplication.service.impl.CarritoServiceImpl;
import com.LootZone.domain.entity.UserEntity;
import com.LootZone.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
public class CarritoController {
    private final CarritoServiceImpl service;
    private final IUserRepository userRepository;


    @PutMapping("/juegos")
    public ResponseEntity<CarritoResponseDTO> editarCarrito(
            Authentication authentication,
            @RequestBody CarritoJuegosRequestDTO dto) {

        String username = authentication.getName();
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return ResponseEntity.ok(service.editarCarritoJuegos(user, dto));
    }


    @GetMapping
    public ResponseEntity<CarritoResponseDTO> buscarPorToken(Authentication authentication) {
        String username = authentication.getName();
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return ResponseEntity.ok(service.buscarXUsuario(user));
    }

}
