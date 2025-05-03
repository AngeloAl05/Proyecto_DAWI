package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.factura.FacturaRequestDTO;
import com.LootZone.aplication.dto.factura.FacturaResponseDTO;
import com.LootZone.aplication.dto.usuario.UsuarioResponseDTO;
import com.LootZone.aplication.service.FacturaService;
import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.Factura;
import com.LootZone.domain.entity.UserEntity;
import com.LootZone.domain.mapper.FacturaMapper;
import com.LootZone.domain.repository.CarritoRepository;
import com.LootZone.domain.repository.FacturaRepository;
import com.LootZone.domain.repository.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {
    private final FacturaMapper facturaMapper;
    private final FacturaRepository facturaRepository;
    private final CarritoRepository carritoRepository;
    private final IUserRepository userRepository;
    private final UsuarioSeviceImpl usuarioSevice;


    @Override
    public List<FacturaResponseDTO> listar(String username) {
        UserEntity usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));

        return facturaRepository.findByUsuario(usuario).stream()
                .map(facturaMapper::toDTO)
                .toList();
    }

    public FacturaResponseDTO buscarXID(Long id){
        return facturaRepository.findById(id).map(facturaMapper::toDTO).orElseThrow(()-> new RuntimeException("No se encontró el ID:" + id));

    }


    @Override
    @Transactional
    public FacturaResponseDTO crear(String username, FacturaRequestDTO dto) {
        UserEntity usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario"));

        Carrito carrito = carritoRepository.findByUsuarioAndActivoTrue(usuario)
                .orElseThrow(() -> new RuntimeException("No se encontró el carrito activo del usuario"));
        carrito.setActivo(false);
        carrito.setFactura(null);
        carritoRepository.save(carrito);


        Factura factura = facturaMapper.toEntity(dto, carrito, usuario);
        Factura nuevaFactura = facturaRepository.save(factura);

        Carrito nuevoCarrito = Carrito.builder()
                .activo(true)
                .usuario(usuario)
                .juegos(new HashSet<>())
                .build();
        carritoRepository.save(nuevoCarrito);

        return facturaMapper.toDTO(nuevaFactura);
    }
}
