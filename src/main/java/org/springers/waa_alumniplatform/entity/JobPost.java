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
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Industry industry;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Company company;
    @ManyToOne
    private Alumni poster;
    @OneToMany
    private List<Alumni> applicants;
    private LocalDateTime postedAt;
}
