package com.maatlabs.userservice.service;

import com.maatlabs.userservice.beans.dtos.PIIActionRequest;
import com.maatlabs.userservice.beans.dtos.PIIActionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    Logger LOG = LoggerFactory.getLogger(MessageConsumerService.class);

    @Autowired
    private MessageProducerService producerService;

    @KafkaListener(topics = "userTopic", groupId = "userServiceGroup")
    void listener(PIIActionRequest event) {
        LOG.info("\n**********\n Got PII event from Quiz Service \n*********\n");
        LOG.info(event.toString());
        LOG.info("\n**********\n Sending PII response event to Quiz Service \n*********\n");
        PIIActionResponse response = new PIIActionResponse();
        response.setRequestId(event.getRequestId());
        response.setResponderId("userservice");
        response.setStatus("SUCCESS");
        producerService.sendCustomMessage(response, "quizTopic");
    }
}
