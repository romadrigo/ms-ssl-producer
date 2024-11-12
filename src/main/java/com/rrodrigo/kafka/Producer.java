package com.rrodrigo.kafka;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rrodrigo.model.AlumnoRequest;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.topic.notas}")
    private String topic;

    @Transactional
    public void send(AlumnoRequest message) throws InterruptedException, ExecutionException, TimeoutException {
        kafkaTemplate.send(topic, null, message).get(20, TimeUnit.SECONDS);
        logger.info("sending message='{}' with partition='{}'", message);
    }
}