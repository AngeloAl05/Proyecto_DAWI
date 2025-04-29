package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.FacturaService;
import com.LootZone.domain.mapper.FacturaMapper;
import com.LootZone.domain.repository.FacturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl  implements FacturaService {
    private final FacturaMapper facturaMapper;
    private final FacturaRepository facturaRepository;


    @Override
    public List<FacturaResponseDTO> listar(){
        return facturaRepository.findAll().stream().map(facturaMapper::toDTO).toList();
    }

    public FacturaResponseDTO buscarXID(Long id){
        return facturaRepository.findById(id).map(facturaMapper::toDTO).orElseThrow(()-> new RuntimeException("No se encontró el ID:" + id));

    }


}
