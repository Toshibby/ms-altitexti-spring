package com.example.ms_inventario.controller;

import com.example.ms_inventario.dto.InventarioDTO;
import com.example.ms_inventario.entity.Inventario;
import com.example.ms_inventario.service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    // Listar todos los movimientos de inventario
    @GetMapping
    public ResponseEntity<List<InventarioDTO>> listarInventario() {
        List<InventarioDTO> inventario = inventarioService.listarInventario();
        return ResponseEntity.ok(inventario);
    }

    // Obtener un movimiento de inventario por ID
    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> obtenerInventario(@PathVariable Long id) {
        return inventarioService.obtenerInventarioPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo movimiento de inventario
    @PostMapping
    public ResponseEntity<InventarioDTO> crearInventario(@RequestBody InventarioDTO inventarioDTO) {
        InventarioDTO guardado = inventarioService.guardarInventario(inventarioDTO);
        InventarioDTO dto = new InventarioDTO();
        // Convertir guardado a DTO (puedes usar mapper o manualmente)
        dto.setIdInventario(guardado.getIdInventario());
        dto.setProductoId(guardado.getProductoId());
        dto.setTipoMovimiento(guardado.getTipoMovimiento());
        dto.setCantidad(guardado.getCantidad());
        dto.setFecha(guardado.getFecha());
        dto.setReferencia(guardado.getReferencia());
        return ResponseEntity.ok(dto);
    }

    // Actualizar un movimiento de inventario existente
    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> actualizarInventario(@PathVariable Long id, @RequestBody InventarioDTO inventarioDTO) {
        try {
            InventarioDTO actualizado = inventarioService.actualizarInventario(id, inventarioDTO);
            InventarioDTO dto = new InventarioDTO();
            dto.setIdInventario(actualizado.getIdInventario());
            dto.setProductoId(actualizado.getProductoId());
            dto.setTipoMovimiento(actualizado.getTipoMovimiento());
            dto.setCantidad(actualizado.getCantidad());
            dto.setFecha(actualizado.getFecha());
            dto.setReferencia(actualizado.getReferencia());
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un movimiento de inventario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Long id) {
        inventarioService.eliminarInventario(id);
        return ResponseEntity.noContent().build();
    }

    // Opcional: Listar movimientos por productoId
    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<InventarioDTO>> listarPorProducto(@PathVariable Long productoId) {
        List<InventarioDTO> lista = inventarioService.listarPorProductoId(productoId);
        return ResponseEntity.ok(lista);
    }

    // Opcional: Listar movimientos por tipo de movimiento
    @GetMapping("/tipo/{tipoMovimiento}")
    public ResponseEntity<List<InventarioDTO>> listarPorTipo(@PathVariable String tipoMovimiento) {
        List<InventarioDTO> lista = inventarioService.listarPorTipoMovimiento(tipoMovimiento);
        return ResponseEntity.ok(lista);
    }
}
