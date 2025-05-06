package com.LootZone.aplication.service.impl;

import com.LootZone.aplication.dto.genero.GeneroJuegosResponseDTO;
import com.LootZone.aplication.dto.genero.GeneroRequestDTO;
import com.LootZone.aplication.dto.genero.GeneroResponseDTO;
import com.LootZone.aplication.dto.juego.JuegoResponseDTO;
import com.LootZone.aplication.service.GeneroService;
import com.LootZone.domain.entity.Genero;
import com.LootZone.domain.entity.Juego;
import com.LootZone.domain.mapper.GeneroMapper;
import com.LootZone.domain.mapper.JuegoMapper;
import com.LootZone.domain.repository.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


