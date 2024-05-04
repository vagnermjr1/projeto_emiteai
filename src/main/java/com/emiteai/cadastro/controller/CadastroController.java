package com.emiteai.cadastro.controller;


import com.emiteai.cadastro.config.RequestInterceptor;
import com.emiteai.cadastro.model.Pessoa;
import com.emiteai.cadastro.service.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "http://localhost:3000")
public class CadastroController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private RequestInterceptor requestInterceptor;

    @PutMapping("/pessoa")
    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }
}
