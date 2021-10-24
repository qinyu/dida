package com.dida.qa.infrastructure;

import com.dida.qa.domain.Question;
import com.dida.qa.domain.repository.QuestionRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepositoryJpa extends CrudRepository<Question, Long>, QuestionRepository {
}