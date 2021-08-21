package com.cadastro.clientes.service;

import com.cadastro.clientes.model.Cliente;
import com.cadastro.clientes.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente buscaPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public Cliente salvar(Cliente cliente){
        cliente.getEnderecos().forEach(c -> c.setCliente(cliente));
        return repository.save(cliente);
    }

    public Cliente alterar(Integer id, Cliente cliente){
        cliente.getEnderecos().forEach(c -> c.setCliente(cliente));
        Cliente clienteAlterar = buscaPorId(id);
        if(clienteAlterar == null){
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(cliente, clienteAlterar, "id");
        repository.save(clienteAlterar);
        return  clienteAlterar;
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }
}
