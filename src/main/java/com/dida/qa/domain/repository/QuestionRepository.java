package com.dida.qa.domain.repository;

import com.dida.qa.domain.Question;

import java.util.List;

public interface QuestionRepository {
    Question save(Question question);

    List<Question> findBySubmittedBy(long submittedBy);
}
