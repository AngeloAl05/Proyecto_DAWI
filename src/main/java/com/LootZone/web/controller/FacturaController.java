package com.LootZone.web.controller;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.impl.FacturaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/factura")
public class FacturaController {
    private final FacturaServiceImpl service;

    @GetMapping
    public List<FacturaResponseDTO> listar(){
        return service.listar();
    }
    @PostMapping
    public FacturaResponseDTO crear(@RequestBody FacturaRequestDTO requestDTO){
        return service.crear(requestDTO);
    }

    @GetMapping("/{id}")
    public FacturaResponseDTO buscarXID(@PathVariable Long id){
        return service.buscarXID(id);
    }
}

