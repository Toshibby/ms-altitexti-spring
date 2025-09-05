package com.example.ms_venta.service;

import com.example.ms_venta.entity.TipoVenta;
import jdk.jfr.Category;

import java.util.List;
import java.util.Optional;

public interface TipoVentaService {
    List<TipoVenta> listarTipoVentas();
    Optional<TipoVenta> obtenerTipoVentaPorId (Long id);
    TipoVenta guardarTipoVenta(TipoVenta tipoVenta);
    TipoVenta actualizarTipoVenta(Long id, TipoVenta tipoVenta);
    void eliminarTipoVenta (Long id);
}
