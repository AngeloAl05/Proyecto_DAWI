package com.LootZone.web.controller;

import com.LootZone.aplication.dto.juego.JuegoRequestDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.aplication.service.impl.JuegoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juego")
@RequiredArgsConstructor
public class JuegoController {
    private final JuegoServiceImpl service;

    @GetMapping
    public List<JuegoResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public JuegoResponseDTO crear(@RequestBody JuegoRequestDTO requestDTO){
        return  service.crear(requestDTO);
    }

    }

