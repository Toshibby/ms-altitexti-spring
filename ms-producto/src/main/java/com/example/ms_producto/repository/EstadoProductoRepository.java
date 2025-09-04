package com.example.ms_producto.repository;

import com.example.ms_producto.entity.EstadoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoProductoRepository extends JpaRepository<EstadoProducto, Long> {
}
