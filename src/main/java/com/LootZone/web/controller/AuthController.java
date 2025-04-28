package com.LootZone.web.controller;

import com.LootZone.aplication.dto.usuario.LoginRequest;
import com.LootZone.aplication.dto.usuario.LoginResponse;
import com.LootZone.aplication.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService service;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        LoginResponse response = service.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }

}