package com.maatlabs.quizservice.services;

import com.maatlabs.quizservice.beans.dtos.PIIActionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    Logger LOG = LoggerFactory.getLogger(MessageConsumerService.class);

    @KafkaListener(topics = "quizTopic", groupId = "quizServiceGroup")
    void listener(PIIActionResponse event) {
        LOG.info("\n**********\n Got PII event response from User Service \n*********\n");
        LOG.info(event.toString());
    }
}
