package com.maatlabs.userservice.service.customlib;

import com.chargebee.cbkafkaspringbootstarter.EventPublisher;
import com.chargebee.cbkafkaspringbootstarter.Event;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "eventstarter.enabled", havingValue = "true")
public class EventGenerator {
    private final EventPublisher eventPublisher;

    public EventGenerator(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Scheduled(fixedRate = 2000)
    void generateEvent() {
        System.out.println("\n\n\n ******** Scheduled job running ********\n\n\n");
        Event event = new Event("foo", "This is a foo event");
        eventPublisher.publishEvent(event);
    }

}
