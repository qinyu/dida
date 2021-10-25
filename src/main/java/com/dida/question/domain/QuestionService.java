package com.dida.question.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    public QuestionService(QuestionRepository questionRepository,
                           AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Question submitQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Answer submitAnswer(long questionId, Answer answer) {
        answer.setQuestionId(questionId);
        return answerRepository.save(answer);
    }

    public List<Question> queryQuestionList(long submittedBy) {
        return questionRepository.findBySubmittedBy(submittedBy);
    }

    public List<Answer> queryAnswerList(long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    public List<Question> queryQuestionList() {
        return questionRepository.findAll();
    }
}
