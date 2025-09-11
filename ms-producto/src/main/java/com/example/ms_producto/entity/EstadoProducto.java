package com.example.ms_producto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado_producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idEstadoProducto;

    @Column(nullable = false, length = 50, name = "nombre")
    public String nombre; // Valores posibles: Activo, Inactivo, Agotado, Discontinuado
}
