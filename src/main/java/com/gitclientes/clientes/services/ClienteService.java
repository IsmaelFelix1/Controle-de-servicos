package com.gitclientes.clientes.services;

import com.gitclientes.clientes.entities.Cliente;
import com.gitclientes.clientes.exceptions.ResourceNotFoundException;
import com.gitclientes.clientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public void delete(Integer id){
        try{
            clienteRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            throw  new ResourceNotFoundException(id);
        }

    }

    public Cliente update(Integer id, Cliente obj ){
        try{
            Cliente entity = clienteRepository.getOne(id);
            updateData(entity, obj);
            return clienteRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException(id);
        }
     }

    private void updateData( Cliente entity, Cliente obj) {
        entity.setName(obj.getName());
        entity.setCpf(obj.getCpf());
    }

}
