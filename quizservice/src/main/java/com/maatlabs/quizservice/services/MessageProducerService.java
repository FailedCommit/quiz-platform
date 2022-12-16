package com.maatlabs.quizservice.services;

import com.maatlabs.quizservice.beans.dtos.PIIActionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.RoutingKafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MessageProducerService {
    private final Logger LOG = LoggerFactory.getLogger(MessageProducerService.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private RoutingKafkaTemplate routingKafkaTemplate;
    private KafkaTemplate<String, PIIActionRequest> userKafkaTemplate;

    @Autowired
    public MessageProducerService(KafkaTemplate<String, String> kafkaTemplate, RoutingKafkaTemplate routingKafkaTemplate,
                           KafkaTemplate<String, PIIActionRequest> userKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.routingKafkaTemplate = routingKafkaTemplate;
        this.userKafkaTemplate = userKafkaTemplate;
    }

    public void sendMessage(String message, String topicName) {
        LOG.info("Sending : {}", message);
        LOG.info("--------------------------------");

        kafkaTemplate.send(topicName, message);
    }

    public void sendWithRoutingTemplate(String message, String topicName) {
        LOG.info("Sending : {}", message);
        LOG.info("--------------------------------");

        routingKafkaTemplate.send(topicName, message.getBytes());
    }

    public void sendCustomMessage(PIIActionRequest request, String topicName) {
        LOG.info("\n**********\n Quiz service Sending PII event to User Service \n*********\n");
        LOG.info("Sending Json Serializer : {}", request);
        LOG.info("--------------------------------");

        userKafkaTemplate.send(topicName, request);
    }

    public void sendMessageWithCallback(String message, String topicName) {
        LOG.info("Sending : {}", message);
        LOG.info("---------------------------------");
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
        future.whenComplete((result, throwable) -> {
            LOG.info("Success Callback: [{}] delivered with offset -{}",
                    message, result.getRecordMetadata().offset());
            if (throwable != null) {
                LOG.warn("Failure Callback: Unable to deliver message [{}]. {}", message, throwable.getMessage());
            }
        });
    }
}
