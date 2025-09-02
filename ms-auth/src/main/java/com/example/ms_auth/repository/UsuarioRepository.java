package com.example.ms_auth.repository;

import com.example.ms_auth.entity.Usuario;
import com.example.ms_auth.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
