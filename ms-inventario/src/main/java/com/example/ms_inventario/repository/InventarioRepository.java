package com.example.ms_inventario.repository;

import com.example.ms_inventario.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    // Opcional: métodos personalizados, por ejemplo, buscar por productoId
    List<Inventario> findByProductoId(Long productoId);

    // Buscar por tipo de movimiento
    List<Inventario> findByTipoMovimiento(String tipoMovimiento);
}
