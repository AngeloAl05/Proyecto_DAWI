package com.LootZone.web.controller;

import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.aplication.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;

    @GetMapping
    public List<UsuarioResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public UsuarioResponseDTO crear(@RequestBody UsuarioRequestDTO requestDTO){
        return  service.crear(requestDTO);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarXId(@PathVariable Long id){
        return service.buscarXID(id);
    }

}
