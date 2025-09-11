package com.example.ms_inventario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name="inventario")
public class Inventario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id_inventario")
    private Long idInventario;

    @Column(name = "producto_id", nullable = false)
    private Long productoId;
//    Aca pongo productoId en lugar de la convencio normal
//    de poner idProducto de la fk que hacemos referencia

    @Column(name = "tipo_movimiento", nullable = false, length = 50)
    public  String tipoMovimiento;

    @Column(nullable = false)
    public  Integer cantidad;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(length = 150)
    private String referencia;

    // Opcional: auditoría
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
