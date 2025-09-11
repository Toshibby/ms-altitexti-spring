package com.example.ms_inventario.dto;

import lombok.Data;

import java.math.BigDecimal;
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class ProductoDTO {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private BigDecimal stock;
    private String unidadMedida;
    private Long categoriaId;       // opcional: solo el id de la categoría
    private Long estadoProductoId;
}
