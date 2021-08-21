package com.cadastro.clientes.service;

import com.cadastro.clientes.dto.EnderecoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ViaCepService {

    public ResponseEntity<EnderecoDTO> getEnderecoByCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();

        String uri = "http://viacep.com.br/ws/{cep}/json/";

        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);
        EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);
        return new ResponseEntity<EnderecoDTO>(enderecoDTO, HttpStatus.OK);
    }

}
