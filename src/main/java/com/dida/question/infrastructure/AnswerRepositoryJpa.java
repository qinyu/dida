package com.dida.question.infrastructure;

import com.dida.question.domain.Answer;
import com.dida.question.domain.AnswerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepositoryJpa extends JpaRepository<Answer, Long>, AnswerRepository {
}