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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl  implements FacturaService {
    private final FacturaMapper facturaMapper;
    private final FacturaRepository facturaRepository;
    private final CarritoRepository carritoRepository;
    private final IUserRepository userRepository;
    private final UsuarioSeviceImpl usuarioSevice;


    @Override
    public List<FacturaResponseDTO> listar(){
        return facturaRepository.findAll().stream().map(facturaMapper::toDTO).toList();
    }

    public FacturaResponseDTO buscarXID(Long id){
        return facturaRepository.findById(id).map(facturaMapper::toDTO).orElseThrow(()-> new RuntimeException("No se encontró el ID:" + id));

    }

    @Override
    public List<FacturaResponseDTO> buscarXUsuario(Long id) {
    /*FALTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA*/

        return null;

    }

    @Override
    public FacturaResponseDTO crear(FacturaRequestDTO dto) {
        Carrito carrito = carritoRepository.findById(dto.getCarrito()).orElseThrow(()-> new RuntimeException("No se encontro el carrito"));
        UserEntity usuario = userRepository.findById(dto.getUsuario()).orElseThrow(()-> new RuntimeException("No se encontro el usuario"));

        Factura factura = facturaMapper.toEntity(dto,carrito,usuario);
        Factura nuevaFactura = facturaRepository.save(factura);
        return facturaMapper.toDTO(nuevaFactura);
    }
}
