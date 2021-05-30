package com.gitclientes.clientes.test;

import com.gitclientes.clientes.entities.Cliente;
import com.gitclientes.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente(null, "Ismael", "06444002346", null);

        clienteRepository.saveAll(Arrays.asList(c1));
    }
}
