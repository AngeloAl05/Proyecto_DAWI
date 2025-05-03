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
    public JuegoResponseDTO buscarXID(Long id) {
        return juegoRepository.findById(id).map(juegoMapper::toDTO).orElseThrow(()-> new RuntimeException("no se encontro el id: " + id));
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

    @Override
    public JuegoResponseDTO editarJuego(Long id_juego, JuegoRequestDTO dto) {
        Juego juegoExistente = juegoRepository.findById(id_juego).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
        Desarrollador desarrollador = desarrolladorRepository.findById(dto.getDesarrollador()).orElseThrow(() -> new RuntimeException("Desarrollador no encontrado"));
        Set<Genero> generos = new HashSet<>(generoRepository.findAllById(dto.getGeneros()));
        if (generos.size() != dto.getGeneros().size()) {
            throw new RuntimeException("Uno o más géneros no existen");
        }
        juegoExistente.setTitulo(dto.getTitulo());
        juegoExistente.setDescripcion(dto.getDescripcion());
        juegoExistente.setImagen(dto.getImagen());
        juegoExistente.setPortada(dto.getPortada());
        juegoExistente.setTrailer(dto.getTrailer());
        juegoExistente.setFecha_lanzamiento(dto.getFecha_lanzamiento());
        juegoExistente.setNum_ventas(dto.getNum_ventas());
        juegoExistente.setCalificaion(dto.getCalificaion());
        juegoExistente.setPrecio(dto.getPrecio());
        juegoExistente.setDesarrollador(desarrollador);
        juegoExistente.setGeneros(generos);
        juegoRepository.save(juegoExistente);
        return juegoMapper.toDTO(juegoExistente);
    }

}
