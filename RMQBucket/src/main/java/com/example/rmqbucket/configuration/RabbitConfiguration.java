package com.example.rmqbucket.configuration;





import java.util.logging.Logger;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfiguration {
    Logger logger = Logger.getLogger(RabbitConfiguration.class.getName());
	

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("192.168.99.100");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("queue-1");
    }

    
    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange("exchange-example-3");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(myQueue1()).to(fanoutExchangeA());
    }


}
