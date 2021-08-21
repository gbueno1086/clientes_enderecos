package com.cadastro.clientes.repository;

import com.cadastro.clientes.model.Cliente;
import com.cadastro.clientes.repository.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {

}
