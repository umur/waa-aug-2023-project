package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SurveyQuestion {
    @Id @GeneratedValue
    private int id;
    private String question;
    @OneToMany(mappedBy = "surveyQuestion", cascade = CascadeType.ALL)
    private List<SurveyAnswer> surveyAnswerList;
}
