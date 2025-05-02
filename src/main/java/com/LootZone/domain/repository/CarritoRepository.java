package com.LootZone.domain.repository;

import com.LootZone.domain.entity.Carrito;
import com.LootZone.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarritoRepository extends JpaRepository<Carrito,Long> {

    Optional<Carrito> findByUsuarioAndActivoTrue(UserEntity usuario);
}
