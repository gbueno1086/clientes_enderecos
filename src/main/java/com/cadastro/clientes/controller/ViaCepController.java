package com.cadastro.clientes.controller;

import com.cadastro.clientes.dto.EnderecoDTO;
import com.cadastro.clientes.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viacep")
public class ViaCepController {

    @Autowired
    ViaCepService viaService;

    @GetMapping(value="/{cep}")
    public ResponseEntity<EnderecoDTO> getCep(@PathVariable(name = "cep") String cep) {
        return viaService.getEnderecoByCep(cep);
    }
}
