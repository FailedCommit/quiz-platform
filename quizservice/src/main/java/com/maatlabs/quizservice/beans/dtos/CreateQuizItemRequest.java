package com.maatlabs.quizservice.beans.dtos;

import com.maatlabs.quizservice.beans.*;
import lombok.Data;

import java.util.List;
import java.util.Map;

import static com.maatlabs.quizservice.beans.QuestionType.*;

@Data
public class CreateQuizItemRequest {
    private Question question;
    private Answer answer;
    private List<Option> options;

    public QuizItem createQuizItem() {
        Question question = createQuestion(this.question);
        Answer answer = createAnswer(this.answer);
        QuizItem item = new QuizItem(question, answer);
        if(MULTIPLE_CHOICE == question.getType() || MULTIPLE_ANSWER == question.getType()) {
            List<Option> options = this.options;
            item.setOptions(options);
        }
        return item;
    }

    private List<Option> createOptions(List<Option> options) {
        // implement later
        return null;
    }

    private Answer createAnswer(Answer ans) {
        Answer answer = new Answer();
        answer.setCorrectOption(ans.getCorrectOption());
        answer.setExplanation(ans.getExplanation());
        return answer;
    }

    private Question createQuestion(Question ques) {
        Question question = new Question();
        question.setText(ques.getText());
        question.setDifficulty(ques.getDifficulty());
        question.setType(ques.getType());
        return question;
    }
}
