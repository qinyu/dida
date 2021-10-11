package com.dida.qa.presentation;

import com.dida.qa.question.application.QuestionService;
import com.dida.qa.question.domain.Answer;
import com.dida.qa.question.domain.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question submitQuestion(@RequestBody Question question) {
        return questionService.submitQuestion(question);
    }

    @GetMapping
    public List<Question> queryQuestionsSubmittedBy(@RequestParam("submittedBy") Long submittedBy) {
        return questionService.queryQuestionList(submittedBy);
    }

    @PostMapping(path= "{id}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public Answer submitAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        return questionService.submitAnswer(id, answer);
    }

    @GetMapping(path = "{id}/answers")
    public List<Answer> queryAnswersOfQuestion(@PathVariable Long id) {
        return questionService.queryAnswerList(id);
    }

}
