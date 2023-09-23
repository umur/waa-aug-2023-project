package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Survey {
    @Id @GeneratedValue
    private int id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SurveyQuestion> questions;
}
