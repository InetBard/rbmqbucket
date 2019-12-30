//package com.example.rmqbucket.configuration;
//
//import java.io.IOException;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecuirityConfiguraion implements {//extends WebSecurityConfigurerAdapter{
//	
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.httpBasic();
////		http.csrf().disable();
////		http.sessionManagement()
////		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////	}
//	public void handleError(ClientHttpResponse response) throws IOException {
//		HttpStatus responseStatus = response.getStatusCode();
//		if (responseStatus.OK != null) {
//			System.err.println("OK HANDLER");
//		}
//	}
//}
