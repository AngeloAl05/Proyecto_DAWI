package com.LootZone.domain.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(nullable = false)
    private boolean activo;
    /*
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity usuario;
    **/
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserEntity usuario;
    @OneToOne(mappedBy = "carrito", cascade = CascadeType.ALL)
    private Factura factura;
    @ManyToMany
    @JoinTable(
            name = "carrito_juegos",
            joinColumns = @JoinColumn(name = "id_carrito"),
            inverseJoinColumns = @JoinColumn(name = "id_juego")
    )
    private Set<Juego> juegos;
}
