package com.cadastro.clientes.controller;


import com.cadastro.clientes.model.Cliente;
import com.cadastro.clientes.repository.ClienteRepository;
import com.cadastro.clientes.repository.filter.ClienteFilter;
import com.cadastro.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;


    @GetMapping
    public Page<Cliente> find(ClienteFilter clienteFilter, Pageable pageable){
        return  repository.filtrar(clienteFilter, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorid(@PathVariable Integer id){
        Cliente clienteBuscado = service.buscaPorId(id);
        return ResponseEntity.ok(clienteBuscado);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        Cliente novoCliente = service.salvar(cliente);
        return  ResponseEntity.ok(novoCliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable Integer id,  @RequestBody Cliente cliente){
        Cliente alteraCliente = service.alterar(id, cliente);
        return  ResponseEntity.ok(alteraCliente);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok(id);
    }
}
