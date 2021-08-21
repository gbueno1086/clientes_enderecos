package com.cadastro.clientes.repository.cliente;

import com.cadastro.clientes.model.Cliente;
import com.cadastro.clientes.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
