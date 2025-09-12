package com.example.ms_inventario.service;

import com.example.ms_inventario.dto.InventarioDTO;
import com.example.ms_inventario.entity.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    // Listar todos los movimientos de inventario
    List<InventarioDTO> listarInventario();

    // Obtener un movimiento de inventario por ID
    Optional<InventarioDTO> obtenerInventarioPorId(Long id);

    // Guardar un nuevo movimiento de inventario
    InventarioDTO guardarInventario(InventarioDTO inventarioDTO);

    // Actualizar un movimiento de inventario existente
    InventarioDTO actualizarInventario(Long id, InventarioDTO inventarioDTO);

    // Eliminar un movimiento de inventario por ID
    void eliminarInventario(Long id);

    // Opcional: Listar movimientos por productoId
    List<InventarioDTO> listarPorProductoId(Long productoId);

    // Opcional: Listar movimientos por tipo de movimiento
    List<InventarioDTO> listarPorTipoMovimiento(String tipoMovimiento);

}
