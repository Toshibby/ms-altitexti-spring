package com.example.ms_producto.service;

import com.example.ms_producto.entity.EstadoProducto;

import java.util.List;
import java.util.Optional;

public interface EstadoProductoService {

    // Listar todos los estados de producto
    List<EstadoProducto> listarEstados();

    // Obtener un estado de producto por ID
    Optional<EstadoProducto> obtenerEstadoPorId(Long id);

    // Guardar un nuevo estado de producto
    EstadoProducto guardarEstado(EstadoProducto estadoProducto);

    // Actualizar un estado de producto existente
    EstadoProducto actualizarEstado(Long id, EstadoProducto estadoProducto);

    // Eliminar un estado de producto por ID
    void eliminarEstado(Long id);
}
