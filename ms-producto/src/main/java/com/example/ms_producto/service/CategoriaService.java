package com.example.ms_producto.service;

import com.example.ms_producto.entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    // Listar todas las categorías
    List<Categoria> listarCategorias();

    // Obtener una categoría por ID
    Optional<Categoria> obtenerCategoriaPorId(Long id);

    // Guardar una nueva categoría
    Categoria guardarCategoria(Categoria categoria);

    // Actualizar una categoría existente
    Categoria actualizarCategoria(Long id, Categoria categoria);

    // Eliminar una categoría por ID
    void eliminarCategoria(Long id);
}
