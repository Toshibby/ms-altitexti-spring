package com.example.ms_producto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(name = "precio_compra", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @Column(name = "precio_venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal stock;

    @Column(name = "unidad_medida", length = 50)
    private String unidadMedida;

    // Relación Many-to-One con Categoria
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categoria categoria;

    // Relación Many-to-One con EstadoProducto
    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private EstadoProducto estadoProducto;

}
