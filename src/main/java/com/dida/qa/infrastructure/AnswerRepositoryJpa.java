package com.dida.qa.infrastructure;

import com.dida.qa.domain.Answer;
import com.dida.qa.domain.repository.AnswerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepositoryJpa extends JpaRepository<Answer, Long>, AnswerRepository {
}