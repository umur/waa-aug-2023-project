package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class SurveryQuestion {
    @Id @GeneratedValue
    private int id;
    private String question;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SurveryAnswer> surveryAnswerList;
}
