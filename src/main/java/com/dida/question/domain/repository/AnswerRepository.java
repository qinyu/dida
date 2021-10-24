package com.dida.question.domain.repository;

import com.dida.question.domain.Answer;

import java.util.List;

public interface AnswerRepository {
    Answer save(Answer answer);

    List<Answer> findByQuestionId(long questionId);
}
