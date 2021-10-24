package com.dida.qa.domain.repository;

import com.dida.qa.domain.Answer;

import java.util.List;

public interface AnswerRepository {
    Answer save(Answer answer);

    List<Answer> findByQuestionId(long questionId);
}
