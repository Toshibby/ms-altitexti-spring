package com.example.ms_venta.service.impl;

import com.example.ms_venta.entity.TipoVenta;
import com.example.ms_venta.repository.TipoVentaRepository;
import com.example.ms_venta.service.TipoVentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoVentaServiceImpl implements TipoVentaService {

    private final TipoVentaRepository tipoVentaRepository;

    public TipoVentaServiceImpl(TipoVentaRepository tipoVentaRepository) {
        this.tipoVentaRepository = tipoVentaRepository;
    }

    @Override
    public List<TipoVenta> listarTipoVentas() {
        return tipoVentaRepository.findAll();
    }

    @Override
    public Optional<TipoVenta> obtenerTipoVentaPorId(Long id) {
        return tipoVentaRepository.findById(id);
    }

    @Override
    public TipoVenta guardarTipoVenta(TipoVenta tipoVenta) {
        return tipoVentaRepository.save(tipoVenta);
    }

    @Override
    public TipoVenta actualizarTipoVenta(Long id, TipoVenta tipoVenta) {
        return tipoVentaRepository.findById(id)
                .map(tv -> {
                    tv.setNombre(tipoVenta.getNombre());
                    return tipoVentaRepository.save(tv);
                })
                .orElseThrow(() -> new RuntimeException("Tipo de venta no encontrado"));
    }

    @Override
    public void eliminarTipoVenta(Long id) {
        tipoVentaRepository.deleteById(id);
    }
}
