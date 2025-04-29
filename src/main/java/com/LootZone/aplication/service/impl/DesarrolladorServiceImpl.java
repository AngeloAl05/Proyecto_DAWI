package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.desarrollador.DesarrolladorRequestDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorResponseDTO;
import com.LootZone.aplication.service.DesarrolladorService;
import com.LootZone.domain.entity.Desarrollador;
import com.LootZone.domain.mapper.DesarrolladorMapper;
import com.LootZone.domain.repository.DesarrolladorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DesarrolladorServiceImpl implements DesarrolladorService {
    private final DesarrolladorRepository desarrolladorRepository;
    private final DesarrolladorMapper desarrolladorMapper;

    @Override
    public List<DesarrolladorResponseDTO> listar() {
        return desarrolladorRepository.findAll().stream().map(desarrolladorMapper::toDTO).toList();
    }

    @Override
    public DesarrolladorResponseDTO crear(DesarrolladorRequestDTO dto) {
        Desarrollador desarrollador = desarrolladorMapper.toEntity(dto);
        Desarrollador nuevoDesarrollador = desarrolladorRepository.save(desarrollador);
        return desarrolladorMapper.toDTO(nuevoDesarrollador);
    }

    @Override
    public DesarrolladorResponseDTO buscarXID(Long id) {
        return desarrolladorRepository.findById(id).map(desarrolladorMapper::toDTO).orElseThrow(()-> new RuntimeException("no se encontro el id: " + id));
    }
}
