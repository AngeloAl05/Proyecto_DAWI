package com.LootZone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    private double total;
    @OneToOne
    @JoinColumn(name = "id_carrito", nullable = false, unique = true)
    private Carrito carrito;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
