package com.example.ms_producto.controller;

import com.example.ms_producto.entity.EstadoProducto;
import com.example.ms_producto.service.EstadoProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados-producto")
public class EstadoProductoController {

    private final EstadoProductoService estadoProductoService;

    public EstadoProductoController(EstadoProductoService estadoProductoService) {
        this.estadoProductoService = estadoProductoService;
    }

    // Listar todos los estados de producto
    @GetMapping
    public ResponseEntity<List<EstadoProducto>> listarEstados() {
        List<EstadoProducto> estados = estadoProductoService.listarEstados();
        return ResponseEntity.ok(estados);
    }

    // Obtener un estado de producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstadoProducto> obtenerEstado(@PathVariable Long id) {
        return estadoProductoService.obtenerEstadoPorId(id)
                .map(ResponseEntity::ok) // si existe, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // si no, devuelve 404
    }

    // Crear un nuevo estado de producto
    @PostMapping
    public ResponseEntity<EstadoProducto> crearEstado(@RequestBody EstadoProducto estadoProducto) {
        EstadoProducto guardado = estadoProductoService.guardarEstado(estadoProducto);
        return ResponseEntity.ok(guardado);
    }

    // Actualizar un estado de producto existente
    @PutMapping("/{id}")
    public ResponseEntity<EstadoProducto> actualizarEstado(@PathVariable Long id, @RequestBody EstadoProducto estadoProducto) {
        try {
            EstadoProducto actualizado = estadoProductoService.actualizarEstado(id, estadoProducto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 si no existe
        }
    }

    // Eliminar un estado de producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        estadoProductoService.eliminarEstado(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
