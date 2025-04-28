package com.LootZone.aplication.dto.usuario;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoginResponse {
    private String token;
    private String username;
    private List<String> roles;
    private long expirateAt;
}