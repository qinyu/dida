package com.dida.qa.question.repository;

import com.dida.qa.question.domain.Answer;

import java.util.List;

public interface AnswerRepository {
    Answer save(Answer answer);

    List<Answer> findByQuestionId(long questionId);
}
