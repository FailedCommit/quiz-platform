package com.maatlabs.userservice.service;

import com.maatlabs.userservice.beans.dtos.PIIActionResponse;
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
    private KafkaTemplate<String, PIIActionResponse> userKafkaTemplate;

    @Autowired
    public MessageProducerService(KafkaTemplate<String, String> kafkaTemplate, RoutingKafkaTemplate routingKafkaTemplate,
                           KafkaTemplate<String, PIIActionResponse> userKafkaTemplate) {
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

    public void sendCustomMessage(PIIActionResponse request, String topicName) {
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
