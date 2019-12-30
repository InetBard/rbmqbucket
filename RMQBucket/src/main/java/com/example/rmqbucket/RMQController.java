package com.example.rmqbucket;

import java.util.logging.Logger;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rmqbucket.service.RMQBucketService;

@RestController
public class RMQController {
	
	Logger logger = Logger.getLogger(RMQController.class.getName());
	
	@Autowired
    RabbitTemplate template;
	
	@Autowired
	RMQBucketService service;
	
	@PostMapping(value = "/rmqConsume")
	public String consumeMessage(@RequestBody String message) {
		if (message!=null) {
			service.saveRequestLocally(message);
			return "All OK";	
		}
		return "Bad";
	}
	
	@PostMapping(value = "/data")
	public String sendMessage(String request) {
        logger.info("Trying to send a request");
        return "Trying to send a request";
    }
	
	@RequestMapping("/emit")
    @ResponseBody
    String emit(@RequestBody String message) {
        logger.info("Emit to exchange-example-3");
        template.setExchange("exchange-example-3");
        template.convertAndSend(message);
        return "Emit to exchange-example-3";
    }
}
