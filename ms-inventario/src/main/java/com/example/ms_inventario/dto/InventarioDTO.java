// DTO para Inventario
package com.example.ms_inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class InventarioDTO {
    private Long idInventario;
    private Long productoId;         // referencia al Producto
    private String tipoMovimiento;   // entrada, salida, ajuste
    private Integer cantidad;
    private LocalDateTime fecha;
    private String referencia;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // opcional: info básica del producto si quieres incluir datos de ProductoDTO
    private ProductoDTO producto;
}
