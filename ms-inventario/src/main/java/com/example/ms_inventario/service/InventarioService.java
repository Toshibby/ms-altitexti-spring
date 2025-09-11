package com.example.ms_inventario.service;

import com.example.ms_inventario.entity.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    // Listar todos los movimientos de inventario
    List<Inventario> listarInventario();

    // Obtener un movimiento de inventario por ID
    Optional<Inventario> obtenerInventarioPorId(Long id);

    // Guardar un nuevo movimiento de inventario
    Inventario guardarInventario(Inventario inventario);

    // Actualizar un movimiento de inventario existente
    Inventario actualizarInventario(Long id, Inventario inventario);

    // Eliminar un movimiento de inventario por ID
    void eliminarInventario(Long id);

    // Opcional: Listar movimientos por productoId
    List<Inventario> listarPorProductoId(Long productoId);

    // Opcional: Listar movimientos por tipo de movimiento
    List<Inventario> listarPorTipoMovimiento(String tipoMovimiento);

}
