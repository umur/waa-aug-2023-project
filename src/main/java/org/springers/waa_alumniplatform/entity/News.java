package org.springers.waa_alumniplatform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class News {
    @Id @GeneratedValue
    private int id;
    private String title;
    private String desc;
    @OneToOne(cascade = CascadeType.ALL)
    private Admin poster;
    private LocalDateTime postedAt;
}
