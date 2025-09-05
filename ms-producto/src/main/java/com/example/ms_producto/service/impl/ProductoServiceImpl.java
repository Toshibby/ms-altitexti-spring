package com.example.ms_producto.service.impl;

import com.example.ms_producto.entity.Producto;
import com.example.ms_producto.repository.ProductoRepository;
import com.example.ms_producto.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        return productoRepository.findById(id)
                .map(p -> {
                    p.setNombre(producto.getNombre());
                    p.setDescripcion(producto.getDescripcion());
                    p.setPrecioCompra(producto.getPrecioCompra());
                    p.setPrecioVenta(producto.getPrecioVenta());
                    p.setStock(producto.getStock());
                    p.setUnidadMedida(producto.getUnidadMedida());
                    p.setCategoria(producto.getCategoria());
                    p.setEstadoProducto(producto.getEstadoProducto());
                    return productoRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
