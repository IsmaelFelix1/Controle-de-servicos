package com.gitclientes.clientes.resources;

import com.gitclientes.clientes.entities.Cliente;
import com.gitclientes.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente obj){
        obj = clienteService.save(obj);
        return ResponseEntity.ok().body(obj);
    }
}
