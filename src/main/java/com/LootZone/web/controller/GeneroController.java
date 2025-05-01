package com.LootZone.web.controller;

import com.LootZone.aplication.dto.genero.GeneroJuegosResponseDTO;
import com.LootZone.aplication.dto.genero.GeneroRequestDTO;
import com.LootZone.aplication.dto.genero.GeneroResponseDTO;
import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.aplication.service.GeneroService;
import com.LootZone.aplication.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
@RequiredArgsConstructor
public class GeneroController {
    private final GeneroService service;

    @GetMapping
    public List<GeneroResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public GeneroResponseDTO crear(@RequestBody GeneroRequestDTO requestDTO){
        return  service.crear(requestDTO);
    }

    @GetMapping("/{id}")
    public GeneroJuegosResponseDTO buscarXId(@PathVariable Long id){
        return service.buscarXID(id);
    }
}
