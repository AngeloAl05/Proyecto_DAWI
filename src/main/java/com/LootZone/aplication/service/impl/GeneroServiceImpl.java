package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.genero.GeneroJuegosResponseDTO;
import com.LootZone.aplication.dto.genero.GeneroRequestDTO;
import com.LootZone.aplication.dto.genero.GeneroResponseDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.aplication.service.GeneroService;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import com.LootZone.domain.mapper.GeneroMapper;
import com.LootZone.domain.mapper.JuegoMapper;
import com.LootZone.domain.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GeneroServiceImpl implements GeneroService {
    private final GeneroMapper generoMapper;
    private final GeneroRepository generoRepository;
    private final JuegoMapper juegoMapper;

    @Override
    public List<GeneroResponseDTO> listar() {
        return generoRepository.findAll().stream().map(generoMapper::toDTO).toList();
    }

    @Override
    public GeneroResponseDTO crear(GeneroRequestDTO requestDTO) {
        Genero genero = generoMapper.toEntity(requestDTO);
        Genero nuevoGenero = generoRepository.save(genero);
        return generoMapper.toDTO(nuevoGenero);
    }

    @Override
    public GeneroJuegosResponseDTO buscarXID(Long id) {
        List<JuegoResponseDTO> juegosResponseDTOS = generoRepository.findByGeneroId(id).stream().map(juegoMapper::toDTO).toList();
        Genero genero = generoRepository.findById(id).orElseThrow(()-> new RuntimeException("id no encontrado"));
        GeneroJuegosResponseDTO generoJuegosResponseDTO = generoMapper.toGeneroJuegosDto(juegosResponseDTOS, genero);
        return generoJuegosResponseDTO;
    }
}

