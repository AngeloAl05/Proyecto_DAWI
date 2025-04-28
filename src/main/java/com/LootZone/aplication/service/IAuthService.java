package com.LootZone.aplication.service;


import com.LootZone.aplication.dto.usuario.LoginRequest;
import com.LootZone.aplication.dto.usuario.LoginResponse;

public interface IAuthService {
    LoginResponse authenticate(LoginRequest loginRequest);
}
