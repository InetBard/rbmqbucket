package com.example.rmqbucket.service;

import org.springframework.stereotype.Service;

@Service
public interface RMQBucketService {
	boolean saveRequestLocally(String requestMessage);
}
