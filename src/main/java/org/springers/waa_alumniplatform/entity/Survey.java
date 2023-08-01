package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Survey {
    @Id @GeneratedValue
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SurveryQuestion> questions;
}
