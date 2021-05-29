package com.gitclientes.clientes.repositories;

import com.gitclientes.clientes.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
