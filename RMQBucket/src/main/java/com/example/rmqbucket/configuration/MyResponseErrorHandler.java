package com.example.rmqbucket.configuration;

import java.io.IOException;

import org.apache.http.auth.AuthenticationException;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;


public class MyResponseErrorHandler implements ResponseErrorHandler {
	 

	    private static final Log logger = LogFactory.getLog(ResponseErrorHandler.class.getName());

	    @Override
	    public void handleError(ClientHttpResponse clienthttpresponse) throws IOException {

	        if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
	            logger.debug(HttpStatus.FORBIDDEN + " response. Throwing authentication exception");
	            try {
					throw new org.apache.http.auth.AuthenticationException();
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }

	    @Override
	    public boolean hasError(ClientHttpResponse clienthttpresponse) throws IOException {

	        if (clienthttpresponse.getStatusCode() != HttpStatus.OK) {
	            logger.debug("Status code: " + clienthttpresponse.getStatusCode());
	            logger.debug("Response" + clienthttpresponse.getStatusText());
	            logger.debug(clienthttpresponse.getBody());

	            if (clienthttpresponse.getStatusCode() == HttpStatus.FORBIDDEN) {
	                logger.debug("Call returned a error 403 forbidden resposne ");
	                return true;
	            }
	        }
	        return false;
	    }
	}

