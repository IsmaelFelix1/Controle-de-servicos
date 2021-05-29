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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        Cliente c1 = clienteService.findById(id);
        return ResponseEntity.ok().body(c1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
     }

     @PutMapping(value = "{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente obj){
        obj = clienteService.update(id, obj);
        return ResponseEntity.ok().body(obj);
     }
}
