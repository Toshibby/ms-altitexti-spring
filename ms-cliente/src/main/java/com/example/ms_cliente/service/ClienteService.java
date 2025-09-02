package com.example.ms_cliente.service;

import com.example.ms_cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    // Listar todos los clientes
    List<Cliente> listarClientes();

    // Obtener un cliente por ID
    Optional<Cliente> obtenerClientePorId(Long id);

    // Guardar un nuevo cliente
    Cliente guardarCliente(Cliente cliente);

    // Actualizar un cliente existente
    Cliente actualizarCliente(Long id, Cliente cliente);

    // Eliminar un cliente por ID
    void eliminarCliente(Long id);
}
