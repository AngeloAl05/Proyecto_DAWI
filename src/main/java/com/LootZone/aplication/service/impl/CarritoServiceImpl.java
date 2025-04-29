package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.aplication.service.CarritoService;
import com.LootZone.domain.mapper.CarritoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {
    private final CarritoMapper carritoMapper;
    @Override
    public List<CarritoResponseDTO> listar() {
        return List.of();
    }

    @Override
    public CarritoResponseDTO buscarXID(Long id) {
        return null;
    }
}
