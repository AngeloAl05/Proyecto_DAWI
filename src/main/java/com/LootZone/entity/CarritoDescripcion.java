package com.LootZone.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CarritoDescripcion {
    private Long idCarDes;
    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private Carrito id_carrito;
    @ManyToOne
    @JoinColumn(name = "id_juego")
    private Juego id_juego;
}
