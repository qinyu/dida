package com.dida.question.domain;

import com.dida.question.domain.Question;

import java.util.List;

public interface QuestionRepository {
    Question save(Question question);

    List<Question> findBySubmittedBy(long submittedBy);

    List<Question> findAll();

}
