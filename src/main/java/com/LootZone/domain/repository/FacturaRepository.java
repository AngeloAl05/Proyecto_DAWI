package com.LootZone.domain.repository;

import com.LootZone.domain.entity.Factura;
import com.LootZone.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura,Long> {
    List<Factura> findByUsuario(UserEntity usuario);
}
