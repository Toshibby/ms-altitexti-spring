package com.example.ms_inventario.service.impl;

import com.example.ms_inventario.dto.InventarioDTO;
import com.example.ms_inventario.dto.ProductoDTO;
import com.example.ms_inventario.entity.Inventario;
import com.example.ms_inventario.feign.ProductoFeign;
import com.example.ms_inventario.repository.InventarioRepository;
import com.example.ms_inventario.service.InventarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final ProductoFeign productoFeign;

    public InventarioServiceImpl(InventarioRepository inventarioRepository, ProductoFeign productoFeign) {
        this.inventarioRepository = inventarioRepository;
        this.productoFeign = productoFeign;
    }

    private InventarioDTO mapToDTO(Inventario inventario) {
        InventarioDTO dto = new InventarioDTO();
        dto.setIdInventario(inventario.getIdInventario());
        dto.setProductoId(inventario.getProductoId());
        dto.setTipoMovimiento(inventario.getTipoMovimiento());
        dto.setCantidad(inventario.getCantidad());
        dto.setFecha(inventario.getFecha());
        dto.setReferencia(inventario.getReferencia());
        dto.setCreatedAt(inventario.getCreatedAt());
        dto.setUpdatedAt(inventario.getUpdatedAt());

        // Traer info del producto desde microservicio
        ProductoDTO producto = productoFeign.buscarPorId(inventario.getProductoId());
        dto.setProducto(producto);

        return dto;
    }

    @Override
    public List<InventarioDTO> listarInventario() {
        return inventarioRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InventarioDTO> obtenerInventarioPorId(Long id) {
        return inventarioRepository.findById(id)
                .map(this::mapToDTO);
    }

    @Override
    public InventarioDTO guardarInventario(InventarioDTO inventarioDTO) {
        Inventario inventario = new Inventario();
        inventario.setProductoId(inventarioDTO.getProductoId());
        inventario.setTipoMovimiento(inventarioDTO.getTipoMovimiento());
        inventario.setCantidad(inventarioDTO.getCantidad());
        inventario.setFecha(inventarioDTO.getFecha());
        inventario.setReferencia(inventarioDTO.getReferencia());

        Inventario guardado = inventarioRepository.save(inventario);
        return mapToDTO(guardado);
    }

    @Override
    public InventarioDTO actualizarInventario(Long id, InventarioDTO inventarioDTO) {
        Inventario actualizado = inventarioRepository.findById(id)
                .map(i -> {
                    i.setProductoId(inventarioDTO.getProductoId());
                    i.setTipoMovimiento(inventarioDTO.getTipoMovimiento());
                    i.setCantidad(inventarioDTO.getCantidad());
                    i.setFecha(inventarioDTO.getFecha());
                    i.setReferencia(inventarioDTO.getReferencia());
                    return inventarioRepository.save(i);
                })
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        return mapToDTO(actualizado);
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public List<InventarioDTO> listarPorProductoId(Long productoId) {
        return inventarioRepository.findByProductoId(productoId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventarioDTO> listarPorTipoMovimiento(String tipoMovimiento) {
        return inventarioRepository.findByTipoMovimiento(tipoMovimiento)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}


//package com.example.ms_inventario.service.impl;
//
//import com.example.ms_inventario.entity.Inventario;
//import com.example.ms_inventario.repository.InventarioRepository;
//import com.example.ms_inventario.service.InventarioService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class InventarioServiceImpl implements InventarioService {
//
//    private final InventarioRepository inventarioRepository;
//
//    public InventarioServiceImpl(InventarioRepository inventarioRepository) {
//        this.inventarioRepository = inventarioRepository;
//    }
//
//    @Override
//    public List<Inventario> listarInventario() {
//        return inventarioRepository.findAll();
//    }
//
//    @Override
//    public Optional<Inventario> obtenerInventarioPorId(Long id) {
//        return inventarioRepository.findById(id);
//    }
//
//    @Override
//    public Inventario guardarInventario(Inventario inventario) {
//        return inventarioRepository.save(inventario);
//    }
//
//    @Override
//    public Inventario actualizarInventario(Long id, Inventario inventario) {
//        return inventarioRepository.findById(id)
//                .map(i -> {
//                    i.setProductoId(inventario.getProductoId());
//                    i.setTipoMovimiento(inventario.getTipoMovimiento());
//                    i.setCantidad(inventario.getCantidad());
//                    i.setFecha(inventario.getFecha());
//                    i.setReferencia(inventario.getReferencia());
//                    return inventarioRepository.save(i);
//                })
//                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
//    }
//
//    @Override
//    public void eliminarInventario(Long id) {
//        inventarioRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Inventario> listarPorProductoId(Long productoId) {
//        return inventarioRepository.findByProductoId(productoId);
//    }
//
//    @Override
//    public List<Inventario> listarPorTipoMovimiento(String tipoMovimiento) {
//        return inventarioRepository.findByTipoMovimiento(tipoMovimiento);
//    }
//}
