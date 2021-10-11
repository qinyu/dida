package com.dida.qa.question.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {
    @Id
    @GeneratedValue
    private long id;
    private long questionId;
    private String content;
    private long submittedBy;
}
