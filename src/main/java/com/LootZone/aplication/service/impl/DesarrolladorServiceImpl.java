package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.desarrollador.DesarrolladorJuegoResponseDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorRequestDTO;
import com.LootZone.aplication.dto.desarrollador.DesarrolladorResponseDTO;
import com.LootZone.aplication.dto.genero.GeneroJuegosResponseDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.aplication.service.DesarrolladorService;
import com.LootZone.domain.entity.Desarrollador;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.mapper.DesarrolladorMapper;
import com.LootZone.domain.mapper.JuegoMapper;
import com.LootZone.domain.repository.DesarrolladorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DesarrolladorServiceImpl implements DesarrolladorService {
    private final DesarrolladorRepository desarrolladorRepository;
    private final DesarrolladorMapper desarrolladorMapper;
    private final JuegoMapper juegoMapper;

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
    public DesarrolladorJuegoResponseDTO buscarXID(Long id) {
        List<JuegoResponseDTO> juegosResponseDTOS = desarrolladorRepository.findByDesarrolladorId(id).stream().map(juegoMapper::toDTO).toList();
        Desarrollador desarrollador = desarrolladorRepository.findById(id).orElseThrow(()-> new RuntimeException("id no encontrado"));
        DesarrolladorJuegoResponseDTO desarrolladorJuegosResponseDTO = desarrolladorMapper.toDesarrolladorJuegosDto(juegosResponseDTOS, desarrollador);
        return desarrolladorJuegosResponseDTO;
    }
}
