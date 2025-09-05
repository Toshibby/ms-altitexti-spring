package com.example.ms_venta.controller;

import com.example.ms_venta.entity.TipoVenta;
import com.example.ms_venta.service.TipoVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-venta")
public class TipoVentaController {

    private final TipoVentaService tipoVentaService;

    public TipoVentaController(TipoVentaService tipoVentaService) {
        this.tipoVentaService = tipoVentaService;
    }

    // Listar todos los tipos de venta
    @GetMapping
    public ResponseEntity<List<TipoVenta>> listarTipoVentas() {
        List<TipoVenta> tipos = tipoVentaService.listarTipoVentas();
        return ResponseEntity.ok(tipos);
    }

    // Obtener un tipo de venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoVenta> obtenerTipoVenta(@PathVariable Long id) {
        return tipoVentaService.obtenerTipoVentaPorId(id)
                .map(ResponseEntity::ok) // 200 OK si existe
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
    }

    // Crear un nuevo tipo de venta
    @PostMapping
    public ResponseEntity<TipoVenta> crearTipoVenta(@RequestBody TipoVenta tipoVenta) {
        TipoVenta guardado = tipoVentaService.guardarTipoVenta(tipoVenta);
        return ResponseEntity.ok(guardado);
    }

    // Actualizar un tipo de venta existente
    @PutMapping("/{id}")
    public ResponseEntity<TipoVenta> actualizarTipoVenta(@PathVariable Long id, @RequestBody TipoVenta tipoVenta) {
        try {
            TipoVenta actualizado = tipoVentaService.actualizarTipoVenta(id, tipoVenta);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }
    }

    // Eliminar un tipo de venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoVenta(@PathVariable Long id) {
        tipoVentaService.eliminarTipoVenta(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
