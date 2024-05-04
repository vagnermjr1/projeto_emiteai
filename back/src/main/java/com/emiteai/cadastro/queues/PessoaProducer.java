//package com.emiteai.cadastro.queues;
//
//import com.emiteai.cadastro.model.Pessoa;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PessoaProducer {
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    public void enviarMensagemCadastro(Pessoa pessoa) {
//        try {
//            rabbitTemplate.convertAndSend("cadastro.pessoa", pessoa);
//            System.out.println("Mensagem de cadastro enviada para RabbitMQ: " + pessoa);
//        } catch (Exception e) {
//            System.err.println("Erro ao enviar mensagem de cadastro para RabbitMQ: " + e.getMessage());
//        }
//    }
//}