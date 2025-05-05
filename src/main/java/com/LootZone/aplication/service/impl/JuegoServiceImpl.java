package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.juego.JuegoRequestDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.aplication.service.JuegoService;
import com.LootZone.domain.entity.Desarrollador;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import com.LootZone.domain.mapper.JuegoMapper;
import com.LootZone.domain.repository.DesarrolladorRepository;
import com.LootZone.domain.repository.GeneroRepository;
import com.LootZone.domain.repository.JuegoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JuegoServiceImpl implements JuegoService {
    private final JuegoRepository juegoRepository;
    private final JuegoMapper juegoMapper;
    private final DesarrolladorRepository desarrolladorRepository;
    private final GeneroRepository generoRepository;


    @Override
    public List<JuegoResponseDTO> listar() {
        return juegoRepository.findAll().stream().map(juegoMapper::toDTO).toList();
    }

    @Override
    public JuegoResponseDTO crear(JuegoRequestDTO dto) {
        Desarrollador desarrollador = desarrolladorRepository.findById(dto.getDesarrollador()).orElseThrow(()->new RuntimeException("No se encontro el desarrollador"));
        Set<Genero> generos = new HashSet<>(generoRepository.findAllById(dto.getGeneros()));
        if (generos.size() != dto.getGeneros().size()) {
            throw new RuntimeException("Uno o más géneros no existen");}
        Juego juego = juegoMapper.toEntity(dto, desarrollador, generos);
        Juego nuevoJuego = juegoRepository.save(juego);
        return juegoMapper.toDTO(nuevoJuego);
    }
}
