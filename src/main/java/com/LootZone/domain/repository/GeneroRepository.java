package com.LootZone.domain.repository;

import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero,Long> {


}
