//package com.emiteai.cadastro.queues;
//
//import com.emiteai.cadastro.model.Pessoa;
//import com.emiteai.cadastro.service.PessoaService;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PessoaConsumer {
//
//    @Autowired
//    private PessoaService pessoaService;
//
//    @RabbitListener(queues = "cadastro.pessoa")
//    public void processarMensagemCadastro(Pessoa pessoa) {
//        System.out.println("Recebida nova mensagem de cadastro: " + pessoa);
//        pessoaService.cadastrarPessoa(pessoa);
//    }
//}
