package com.example.ms_auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(nullable = false, length = 100, name = "nombre_user")
    private String nombre;

    @Column(nullable = false, length = 100, name = "apellido_user")
    private String apellido;

    @Column(nullable = false, unique = true, length = 150, name = "email_user")
    private String email;

    @Column(nullable = false, length = 255, name = "password_user")
    private String password;

    @Column(nullable = false, length = 50, name = "rol_user")
    private String rol;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE", name = "estado_user")
    private Boolean estado = true;

}
