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
    /*
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity usuario;
    **/
    @OneToOne
    @JoinColumn(name = "id_usuario")
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
