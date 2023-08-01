package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class JobPost {
    @Id @GeneratedValue
    private int id;
    private String position;
    private String skills;
    private String otherReq;
    @OneToOne
    private Industry industry;
    @OneToOne
    private Company company;
    @OneToOne
    private Alumni poster;
    @OneToMany
    private List<Alumni> applicants;
    private LocalDateTime postedAt;
}
