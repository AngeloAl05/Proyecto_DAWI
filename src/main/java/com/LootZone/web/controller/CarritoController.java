package com.LootZone.web.controller;

import com.LootZone.aplication.dto.carrito.CarritoJuegosRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.CarritoService;
import com.LootZone.aplication.service.impl.CarritoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@RequiredArgsConstructor
public class CarritoController {
    private final CarritoServiceImpl service;

    @GetMapping
    public List<CarritoResponseDTO> listar(){
        return service.listar();
    }

    @PostMapping
    public CarritoResponseDTO crear(@PathVariable CarritoRequestDTO dto){
        return service.crear(dto);
    }

    @PutMapping("/{id}/juegos")
    public ResponseEntity<CarritoResponseDTO> editarCarrito(@PathVariable Long id, @RequestBody CarritoJuegosRequestDTO dto) {
        return ResponseEntity.ok(service.editarCarritoJuegos(id, dto));
    }

    @GetMapping("/xUsuario/{id}")
    public CarritoResponseDTO buscarXUsuarioID(@PathVariable Long id){
        return service.buscarXUsuario(id);
    }


}
