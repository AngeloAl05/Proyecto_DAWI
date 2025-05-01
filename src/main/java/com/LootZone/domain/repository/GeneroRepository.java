package com.LootZone.domain.repository;

import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero,Long> {

    @Query("SELECT j FROM Juego j JOIN j.generos g WHERE g.id_genero = :idGenero")
    List<Juego> findByGeneroId(@Param("idGenero") Long idGenero);
}
