package com.LootZone.domain.repository;

import com.LootZone.domain.entity.Desarrollador;
import com.LootZone.domain.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador,Long> {

    @Query("SELECT j FROM Juego j JOIN j.desarrollador d WHERE d.id_desarrollador = :idDesarrollador")
    List<Juego> findByDesarrolladorId(@Param("idDesarrollador") Long idDesarrollador);
}
