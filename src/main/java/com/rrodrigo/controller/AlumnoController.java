package com.rrodrigo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrodrigo.kafka.Producer;
import com.rrodrigo.model.AlumnoRequest;

@RestController
@RequestMapping("/api/v1/")
public class AlumnoController {
    
    
	private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);

	@Autowired
    private Producer producer;
	
	@PostMapping(value="alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> post(@RequestBody AlumnoRequest message){
		try {
            logger.info("request received '{}'", message.toString());
			producer.send(message);
			ResponseEntity<String> rpta = new ResponseEntity<String>("", HttpStatus.OK);
			logger.info("executed finalized");
			return rpta;
		}catch(Exception e) {
			logger.error("Error: ",e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
