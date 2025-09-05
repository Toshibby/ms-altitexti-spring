package com.example.ms_venta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "tipo_venta")
public class TipoVenta {
    @Id
    @GeneratedValue
    @Column(name="id_tipo_venta")
    private Long id;

    @Column (nullable = false, length = 50, name = "nombre")
    public String nombre;
}
