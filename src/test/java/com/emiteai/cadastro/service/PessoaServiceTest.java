package com.emiteai.cadastro.service;

import com.emiteai.cadastro.model.Pessoa;
import com.emiteai.cadastro.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void cadastrarPessoa_QuandoCpfNaoExiste_DeveRetornarCreated() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("12345678900");

        when(pessoaRepository.findByCpf(pessoa.getCpf())).thenReturn(null);
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        ResponseEntity<?> responseEntity = pessoaService.cadastrarPessoa(pessoa);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(pessoa, responseEntity.getBody());
        verify(pessoaRepository, times(1)).findByCpf(pessoa.getCpf());
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void cadastrarPessoa_QuandoCpfExiste_DeveRetornarConflict() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("12345678900");

        when(pessoaRepository.findByCpf(pessoa.getCpf())).thenReturn(pessoa);

        ResponseEntity<?> responseEntity = pessoaService.cadastrarPessoa(pessoa);

        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("CPF já cadastrado: " + pessoa.getCpf(), responseEntity.getBody());
        verify(pessoaRepository, times(1)).findByCpf(pessoa.getCpf());
        verify(pessoaRepository, never()).save(pessoa);
    }

    @Test
    void cadastrarPessoa_QuandoErroAoSalvar_DeveRetornarInternalServerError() {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("12345678900");

        when(pessoaRepository.findByCpf(pessoa.getCpf())).thenReturn(null);
        when(pessoaRepository.save(pessoa)).thenThrow(new RuntimeException("Erro ao salvar pessoa"));

        ResponseEntity<?> responseEntity = pessoaService.cadastrarPessoa(pessoa);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Erro ao cadastrar pessoa: Erro ao salvar pessoa", responseEntity.getBody());
        verify(pessoaRepository, times(1)).findByCpf(pessoa.getCpf());
        verify(pessoaRepository, times(1)).save(pessoa);
    }
}
