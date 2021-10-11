package com.dida.qa.question.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private long id;
    private String title;
    private String description;
    private long submittedBy;
}
