package com.pragma.powerup.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "platos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_plato", nullable = false)
    private String nombrePlato;
    private Integer precio;
    private String descripcion;
    @Column(name = "url_imagen")
    private String urlImagen;
    private String categoria;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Column(name = "restaurante_id", nullable = false)
    private Long restauranteId;
}
