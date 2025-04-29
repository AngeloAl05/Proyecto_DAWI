package com.LootZone.web.controller;

import com.LootZone.aplication.dto.desarrollador.DesarrolladorRequestDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorResponseDTO;
import com.LootZone.aplication.service.impl.DesarrolladorServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/desarrollador")
public class DesarrolladorController {
    private final DesarrolladorServiceImpl service;

    @GetMapping
    public List<DesarrolladorResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public DesarrolladorResponseDTO crear(@RequestBody DesarrolladorRequestDTO dto){
        return service.crear(dto);
    }

    @GetMapping("/{id}")
    public DesarrolladorResponseDTO buscarXID(@PathVariable Long id){
        return service.buscarXID(id);
    }

}
