package com.example.ms_producto.service.impl;

import com.example.ms_producto.entity.EstadoProducto;
import com.example.ms_producto.repository.EstadoProductoRepository;
import com.example.ms_producto.service.EstadoProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoProductoServiceImpl implements EstadoProductoService {

    private final EstadoProductoRepository estadoProductoRepository;

    public EstadoProductoServiceImpl(EstadoProductoRepository estadoProductoRepository) {
        this.estadoProductoRepository = estadoProductoRepository;
    }

    @Override
    public List<EstadoProducto> listarEstados() {
        return estadoProductoRepository.findAll();
    }

    @Override
    public Optional<EstadoProducto> obtenerEstadoPorId(Long id) {
        return estadoProductoRepository.findById(id);
    }

    @Override
    public EstadoProducto guardarEstado(EstadoProducto estadoProducto) {
        return estadoProductoRepository.save(estadoProducto);
    }

    @Override
    public EstadoProducto actualizarEstado(Long id, EstadoProducto estadoProducto) {
        return estadoProductoRepository.findById(id)
                .map(e -> {
                    e.setNombre(estadoProducto.getNombre());
                    return estadoProductoRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("Estado de producto no encontrado"));
    }

    @Override
    public void eliminarEstado(Long id) {
        estadoProductoRepository.deleteById(id);
    }
}
