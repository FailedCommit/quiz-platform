package com.maatlabs.userservice;

import com.chargebee.cbkafkaspringbootstarter.EventListener;
import com.chargebee.cbkafkaspringbootstarter.EventListenerProperties;
import com.chargebee.cbkafkaspringbootstarter.EventPublisher;
import com.maatlabs.userservice.service.customlib.FooEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@EnableKafka
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.maatlabs", "com.chargebee"})
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	public EventListenerProperties eventListenerProperties() {
		return new EventListenerProperties();
	}

//	@Bean
//	public EventListener fooEventListener() {
//		return new FooEventListener(new EventListenerProperties());
//	}

	@Bean
	public EventPublisher eventPublisher() {
		EventListener fooEventListener = new FooEventListener(eventListenerProperties());
		return new EventPublisher(List.of(fooEventListener));
	}
}
