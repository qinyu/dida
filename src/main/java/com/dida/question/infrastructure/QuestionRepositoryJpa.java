package com.dida.question.infrastructure;

import com.dida.question.domain.Question;
import com.dida.question.domain.QuestionRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepositoryJpa extends CrudRepository<Question, Long>, QuestionRepository {
}