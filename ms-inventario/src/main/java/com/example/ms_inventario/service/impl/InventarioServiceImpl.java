package com.example.ms_inventario.service.impl;

import com.example.ms_inventario.entity.Inventario;
import com.example.ms_inventario.repository.InventarioRepository;
import com.example.ms_inventario.service.InventarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioServiceImpl(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> listarInventario() {
        return inventarioRepository.findAll();
    }

    @Override
    public Optional<Inventario> obtenerInventarioPorId(Long id) {
        return inventarioRepository.findById(id);
    }

    @Override
    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario actualizarInventario(Long id, Inventario inventario) {
        return inventarioRepository.findById(id)
                .map(i -> {
                    i.setProductoId(inventario.getProductoId());
                    i.setTipoMovimiento(inventario.getTipoMovimiento());
                    i.setCantidad(inventario.getCantidad());
                    i.setFecha(inventario.getFecha());
                    i.setReferencia(inventario.getReferencia());
                    return inventarioRepository.save(i);
                })
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public List<Inventario> listarPorProductoId(Long productoId) {
        return inventarioRepository.findByProductoId(productoId);
    }

    @Override
    public List<Inventario> listarPorTipoMovimiento(String tipoMovimiento) {
        return inventarioRepository.findByTipoMovimiento(tipoMovimiento);
    }
}
