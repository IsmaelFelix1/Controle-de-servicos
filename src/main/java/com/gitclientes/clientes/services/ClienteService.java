package com.gitclientes.clientes.services;

import com.gitclientes.clientes.entities.Cliente;
import com.gitclientes.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente obj){
       return clienteRepository.save(obj);
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.get();
    }
    public void delete(Integer id){
        clienteRepository.deleteById(id);
    }

    public Cliente update(Integer id, Cliente obj ){
        Cliente entity = clienteRepository.getOne(id);
        updateData(entity, obj);
        return clienteRepository.save(entity);
    }

    private void updateData( Cliente entity, Cliente obj) {
        entity.setName(obj.getName());
        entity.setCpf(obj.getCpf());
    }

}
