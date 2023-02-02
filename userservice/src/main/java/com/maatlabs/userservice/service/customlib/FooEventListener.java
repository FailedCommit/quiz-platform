package com.maatlabs.userservice.service.customlib;

import com.chargebee.cbkafkaspringbootstarter.Event;
import com.chargebee.cbkafkaspringbootstarter.EventListener;
import com.chargebee.cbkafkaspringbootstarter.EventListenerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(value = "eventstarter.enabled", havingValue = "true")
public class FooEventListener extends EventListener {

    public FooEventListener(EventListenerProperties properties) {
        super(properties);
    }

    @Override
    public String getSubscribedEventType() {
        return "foo";
    }

    @Override
    protected void onEvent(Event event) {
        log.info("received event {}", event);
        System.out.println("\n\n\n ******** Event Received ********\n\n\n");
    }
}
