package com.example.ms_producto.service.impl;

import com.example.ms_producto.entity.Categoria;
import com.example.ms_producto.repository.CategoriaRepository;
import com.example.ms_producto.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(c -> {
                    c.setNombre(categoria.getNombre());
                    c.setDescripcion(categoria.getDescripcion());
                    return categoriaRepository.save(c);
                })
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
