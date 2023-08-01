package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SurveryAnswer {
    @Id @GeneratedValue
    private int id;
    private String answer;
    @OneToOne(cascade = CascadeType.ALL)
    private Alumni responder;
}
