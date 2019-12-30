package com.example.rmqbucket.service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rmqbucket.RMQController;

import lombok.Getter;
import lombok.Setter;

@EnableRabbit
@Getter
@Setter
@Component
public class RabbitMqListener {
	@Autowired
	RMQBucketService service;
	@Autowired
	RMQController controller;
	
    Logger logger = Logger.getLogger(RabbitMqListener.class.getName());

    @RabbitListener(queues = "queue-1")
    public synchronized void worker1(final String message) {
    	Set<String> stackRequsts = new HashSet<String>();
    	stackRequsts.add(message);
    	service.saveRequestLocally(message);
    	
    	controller.sendMessage(message);
        this.logger.info("accepted on worker 1 : " + message);
    }

}
