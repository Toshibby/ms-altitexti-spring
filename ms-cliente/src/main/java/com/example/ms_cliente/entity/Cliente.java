package com.example.ms_cliente.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(nullable = false, length = 100, name = "nombre_cliente")
    private String nombre;

    @Column(length = 100, name = "apellido_cliente")
    private String apellido; // NULLABLE si es empresa

    @Column(length = 150, name = "razon_social_cliente")
    private String razonSocial; // NULLABLE si es persona

    @Column(unique = true, length = 15, name = "dni_cliente")
    private String dni; // NULLABLE

    @Column(unique = true, length = 15, name = "ruc_cliente")
    private String ruc; // NULLABLE

    @Column(nullable = false, length = 20, name = "telefono_cliente")
    private String telefono;

    @Column(nullable = false, length = 255, name = "direccion_cliente")
    private String direccion;

    @Column(length = 150, unique = true, name = "email_cliente")
    private String email; // NULLABLE
}
