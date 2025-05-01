package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.carrito.CarritoJuegosRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoRequestDTO;
import com.LootZone.aplication.dto.carrito.CarritoResponseDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.service.CarritoService;
import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.Factura;
import com.LootZone.domain.entity.Juego;
import com.LootZone.domain.entity.UserEntity;
import com.LootZone.domain.mapper.CarritoMapper;
import com.LootZone.domain.repository.CarritoRepository;
import com.LootZone.domain.repository.IUserRepository;
import com.LootZone.domain.repository.JuegoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {
    private final CarritoMapper carritoMapper;
    private final CarritoRepository carritoRepository;
    private final JuegoRepository juegoRepository;
    private final IUserRepository userRepository;
    @Override
    public List<CarritoResponseDTO> listar() {
        return carritoRepository.findAll().stream().map(carritoMapper::toDTO).toList();
    }

    @Override
    public CarritoResponseDTO buscarXID(Long id) {
        return carritoRepository.findById(id).map(carritoMapper::toDTO).orElseThrow(()->new RuntimeException("No se encontro el carrito"));
    }



    @Override
    public CarritoResponseDTO editarCarritoJuegos(Long id, CarritoJuegosRequestDTO dto) {
        Carrito carrito = carritoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        if (dto.getJuegosAgregar() != null && !dto.getJuegosAgregar().isEmpty()) {
            Set<Juego> juegosParaAgregar = new HashSet<>(juegoRepository.findAllById(dto.getJuegosAgregar()));
            if (juegosParaAgregar.size() != dto.getJuegosAgregar().size()) {
                throw new RuntimeException("Uno o más géneros a agregar no existen");
            }
            carrito.getJuegos().addAll(juegosParaAgregar);
        }

        if (dto.getJuegosEliminar() != null && !dto.getJuegosEliminar().isEmpty()) {
            Set<Juego> juegosParaEliminar = new HashSet<>(juegoRepository.findAllById(dto.getJuegosEliminar()));
            if (juegosParaEliminar.size() != dto.getJuegosEliminar().size()) {
                throw new RuntimeException("Uno o más géneros a eliminar no existen");
            }
            carrito.getJuegos().removeAll(juegosParaEliminar);
        }

        carritoRepository.save(carrito);
        return carritoMapper.toDTO(carrito);
    }

    @Override
    public CarritoResponseDTO crear(CarritoRequestDTO dto) {
        UserEntity usuario = userRepository.findById(dto.getUsuario()).orElseThrow(()-> new RuntimeException("No se encontro el usuario"));
        Carrito carrito = carritoMapper.toEntity(usuario);
        Carrito nuevoCarrito = carritoRepository.save(carrito);
        return carritoMapper.toDTO(nuevoCarrito);
    }

    @Override
    public CarritoResponseDTO buscarXUsuario(Long id) {
        CarritoResponseDTO carritoEncontrado = null;
        List<CarritoResponseDTO> carritos = listar();
        for (CarritoResponseDTO c:carritos){
            if (c.getUsuario().getId_usuario().equals(id)){
                carritoEncontrado = c;
            }
        }
        return carritoEncontrado;
    }


}
