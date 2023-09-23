package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    @Id @GeneratedValue
    private int id;
    private String position;
    private String skills;
    private String otherReq;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Industry industry;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Company company;
    @ManyToOne
    private Alumni poster;
    @ManyToMany
    private List<Alumni> applicants;
    private LocalDateTime postedAt;
}
