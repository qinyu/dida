package com.dida.qa.presentation;

import com.dida.qa.question.domain.Answer;
import com.dida.qa.question.domain.Question;
import com.dida.qa.question.domain.Question.QuestionBuilder;
import com.dida.qa.question.repository.AnswerRepository;
import com.dida.qa.question.repository.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {QuestionController.class})
class QuestionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuestionRepository questionRepository;

    @MockBean
    AnswerRepository answerRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void should_return_questions_list_submitted_by_user() throws Exception {
        List<Question> questions = singletonList(new Question(1234,
                "this is a question",
                "this is description of question",
                5678));
        given(questionRepository.findBySubmittedBy(5678)).willReturn(questions);

        MockHttpServletRequestBuilder request = get("/questions").param("submittedBy", "5678");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1234)));
    }

    @Test
    void should_return_answer_list_of_question() throws Exception {
        List<Answer> answers = singletonList(new Answer(1234, "this is an answer", 5678));
        given(answerRepository.findByQuestionId(1234)).willReturn(answers);

        MockHttpServletRequestBuilder request = get("/questions/{id}/answers", 1234);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].questionId", is(1234)));
    }

    @Test
    void should_create_question() throws Exception {
        QuestionBuilder questionBuilder = Question.builder().
                title("this is a question")
                .description("this is description of question")
                .submittedBy(5678);
        String requestBody = objectMapper.writeValueAsString(questionBuilder.build());
        given(questionRepository.save(any())).willReturn(questionBuilder.id(1234).build());

        MockHttpServletRequestBuilder request = post("/questions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", is(1234)))
                .andExpect(jsonPath("submittedBy", is(5678)));
    }

    @Test
    void should_create_answer_for_question() throws Exception {
        Answer answer = new Answer();
        answer.setSubmittedBy(5678);
        answer.setContent("this is an anwser");
        String requestBody = objectMapper.writeValueAsString(answer);
        given(answerRepository.save(any())).willReturn(new Answer(1234, "this is an answer", 5678));

        MockHttpServletRequestBuilder request = post("/questions/{id}/anwsers", 1234)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);
        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("questionId", is(1234)));
    }
}