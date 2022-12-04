package com.maatlabs.quizservice.api;

import com.maatlabs.quizservice.beans.Answer;
import com.maatlabs.quizservice.beans.QuizItem;
import com.maatlabs.quizservice.beans.dtos.*;
import com.maatlabs.quizservice.components.QuizWebClient;
import com.maatlabs.quizservice.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RequiredArgsConstructor
@RestController
public class QuizApi {
    private final QuizWebClient webClient;
    private final QuizService quizService;

    // Create a Quiz item (Question and answers)
    // Get a Question to present the quiz to the user
    // Get the Answer to verify if user answered correctly + details around right and wrong answers
    @PostMapping("/question")
    public ResponseEntity<QuizItem> createQuizItem(@RequestBody CreateQuizItemRequest request) {
        QuizItem quizItem = quizService.createQuizItem(request);
        return ok(quizItem);
    }

    @GetMapping("/question/{questionItemId}")
    public ResponseEntity<GetQuestionResponse> getQuestion(@PathVariable String questionItemId) {
        // return any question that has not been asked before and is not marked delete
        QuizItem quizItem = quizService.getQuizItem(questionItemId);
        GetQuestionResponse response = new GetQuestionResponse();
        response.setQuestion(quizItem.getQuestion());
        response.setOptions(quizItem.getOptions());
        return ok(response);
    }

    // TODO: good usecase for a loading cache, why go to db for answer. If question is out there someone will be coming soon to verify
    @PostMapping("/answer")
    public ResponseEntity<VerifyAnswerResponse> verifyAnswer(@RequestBody VerifyAnswerRequest request) {
        QuizItem quizItem = quizService.getQuizItem(request.getQuizItemId());
        Answer answer = quizItem.getAnswer();
        VerifyAnswerResponse response = new VerifyAnswerResponse();
        if(request.getSelectedOptions().contains(answer.getCorrectOption())) {
            response.setCorrectAnswer(true);
        }
        response.setExplanation(answer.getExplanation());
        return ok(response);
    }

    @GetMapping("/greet")
    public String hi() {
        String message = webClient.get("http://userservice:8091/hi", String.class);
        return "Quiz Service says: " + message;
    }

    @GetMapping("/test")
    public String test() {
        return "Quiz Service is working fine ";
    }
}
