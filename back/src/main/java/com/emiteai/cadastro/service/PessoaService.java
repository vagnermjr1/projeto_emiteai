package com.emiteai.cadastro.service;


import com.emiteai.cadastro.model.Pessoa;
import com.emiteai.cadastro.repository.PessoaRepository;
import com.emiteai.cadastro.util.DuplicidadeCpfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        try {
           if(validarDuplicidadeCpf(pessoa.getCpf())){
               pessoa = pessoaRepository.save(pessoa);
               return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
           }else{
               return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado: " + pessoa.getCpf());
           }
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar pessoa: " + e.getMessage());
        }
    }

    private boolean validarDuplicidadeCpf(String cpf) {
        if (pessoaRepository.findByCpf(cpf) != null) {
            return false;
        }else{
            return true;
        }
    }

    public List<Pessoa> listarPessoas() {
        try {
            return pessoaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar pessoas: " + e.getMessage());
        }
    }
}