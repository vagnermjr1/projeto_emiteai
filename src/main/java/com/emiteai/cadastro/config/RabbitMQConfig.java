//package com.emiteai.cadastro.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String QUEUE_NAME = "cadastro-pessoa-queue";
//    public static final String EXCHANGE_NAME = "cadastro-pessoa-exchange";
//    public static final String ROUTING_KEY = "cadastro-pessoa";
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME, false);
//    }
//
//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange(EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
//    }
//}