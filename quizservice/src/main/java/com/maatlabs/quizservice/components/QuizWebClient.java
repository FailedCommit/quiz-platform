package com.maatlabs.quizservice.components;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class QuizWebClient {
    public <K, T> K post(String url, T request, Class<K> clazz) {
        K response = WebClient.builder().build()
                .post()
                .uri(url)
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToMono(clazz)
                .block();
        return response;
    }

    public <K, T> K get(String url, Class<K> clazz) {
        K response = WebClient.builder().build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(clazz)
                .block();
        return response;
    }
}