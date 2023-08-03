package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class SurveyAnswer {
    @Id @GeneratedValue
    private int id;
    private String answer;
    @ManyToOne
    private SurveyQuestion surveyQuestion;
    @ManyToOne
    private Alumni responder;
}
