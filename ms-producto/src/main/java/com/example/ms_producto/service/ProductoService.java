package com.example.ms_producto.service;

import com.example.ms_producto.entity.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {

    // Listar todos los productos
    List<Producto> listarProductos();

    // Obtener un producto por ID
    Optional<Producto> obtenerProductoPorId(Long id);

    // Guardar un nuevo producto
    Producto guardarProducto(Producto producto);

    // Actualizar un producto existente
    Producto actualizarProducto(Long id, Producto producto);

    // Eliminar un producto por ID
    void eliminarProducto(Long id);
}
