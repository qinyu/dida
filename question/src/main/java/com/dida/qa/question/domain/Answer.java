package com.dida.qa.question.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private long questionId;
    private String content;
    private long submittedBy;
}
