package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.dto.genero.GeneroRequestDTO;
import com.LootZone.aplication.dto.genero.GeneroResponseDTO;
import com.LootZone.aplication.dto.usuario.UsuarioRequestDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.aplication.service.FacturaService;
import com.LootZone.domain.entity.Factura;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.UserEntity;
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

    public FacturaResponseDTO crear(FacturaRequestDTO requestDTO) {
        Factura factura = facturaMapper.toEntity(requestDTO);
        Factura nuevaFactura = facturaRepository.save(factura);
        return facturaMapper.toDTO(nuevaFactura);
    }

    public FacturaResponseDTO buscarXID(Long id){
        return facturaRepository.findById(id).map(facturaMapper::toDTO).orElseThrow(()-> new RuntimeException("No se encontró el ID:" + id));

    }




}
