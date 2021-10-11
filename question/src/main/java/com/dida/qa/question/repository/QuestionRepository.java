package com.dida.qa.question.repository;

import com.dida.qa.question.domain.Question;

import java.util.List;

public interface QuestionRepository {
    Question save(Question question);

    List<Question> findBySubmittedBy(long submittedBy);
}
