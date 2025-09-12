package com.example.ms_inventario.feign;

import com.example.ms_inventario.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="ms-producto", path = "/productos")
public interface ProductoFeign {
    @GetMapping("/{id}")
    public ProductoDTO buscarPorId(@PathVariable Long id);
}
