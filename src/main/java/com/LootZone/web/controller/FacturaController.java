package com.LootZone.web.controller;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.impl.FacturaServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/factura")
public class FacturaController {
    private final FacturaServiceImpl service;


    @GetMapping
    public List<FacturaResponseDTO> listar(Authentication authentication) {
        String username = authentication.getName();
        return service.listar(username);
    }

    @PostMapping
    public FacturaResponseDTO crear(Authentication authentication,
                                    @RequestBody FacturaRequestDTO requestDTO) {
        String username = authentication.getName();
        return service.crear(username, requestDTO);
    }

    @GetMapping("/{id}")
    public FacturaResponseDTO buscarXID(@PathVariable Long id){
        return service.buscarXID(id);
    }

}

