package com.emiteai.cadastro.repository;


import com.emiteai.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Pessoa findByCpf(String cpf);


}