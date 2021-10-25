package com.dida.question.domain;

import com.dida.question.domain.Answer;
import com.dida.question.domain.Question;
import com.dida.question.domain.QuestionService;
import com.dida.question.domain.AnswerRepository;
import com.dida.question.domain.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class QuestionServiceTest {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionRepository = mock(QuestionRepository.class);
        answerRepository = mock(AnswerRepository.class);
        questionService = new QuestionService(questionRepository, answerRepository);
    }

    @Test
    void should_save_question_with_repository() {
        Question question = new Question(1234L, "this is a question", "this is description", 5678L);
        given(questionRepository.save(question)).willReturn(question);
        Question submittedQuestion = questionService.submitQuestion(question);
        assertEquals(submittedQuestion, question);
        verify(questionRepository).save(question);
    }

    @Test
    void should_save_answer_of_question() {
        Answer answer = new Answer(1, 1234L, "this is an answer", 5678);
        given(answerRepository.save(answer)).willReturn(answer);

        Answer submittedAnswer = questionService.submitAnswer(1234L, answer);
        assertEquals(answer, submittedAnswer);
        assertEquals(1234L, submittedAnswer.getQuestionId());
        verify(answerRepository).save(answer);
    }

    @Test
    void should_find_questions_submitted_by_user() {
        given(questionRepository.findBySubmittedBy(5678L)).willReturn(singletonList(new Question()));

        List<Question> questions = questionService.queryQuestionList(5678L);
        assertEquals(1, questions.size());
        verify(questionRepository).findBySubmittedBy(5678L);
    }

    @Test
    void should_find_answers_of_question() {
        given(answerRepository.findByQuestionId(1234L)).willReturn(singletonList(new Answer()));

        List<Answer> answers = questionService.queryAnswerList(1234L);
        assertEquals(1, answers.size());
        verify(answerRepository).findByQuestionId(1234L);
    }
}