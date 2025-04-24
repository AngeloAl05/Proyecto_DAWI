package com.LootZone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "Carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CarritoDescripcion> carritoDescripcion = new HashSet<>();
}
