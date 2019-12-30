package com.example.rmqbucket.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class RMQBucketServiceImpl implements RMQBucketService {

	@Override
	public boolean saveRequestLocally(String requestMessage) {
		String filename = "-request.txt";
		File path = new File("C:\\dir2");
		path.mkdirs();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-(HH-mm-ss)");
		File file = new File(path, LocalDateTime.now().format(formatter)+filename);
		try (PrintWriter out = new PrintWriter(file)) {
		    out.println(requestMessage);
		    return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

}
