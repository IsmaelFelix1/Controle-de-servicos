package com.gitclientes.clientes.repositories;

import com.gitclientes.clientes.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
