package com.example.springproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.springproject.entity.User;
import com.example.springproject.entity.Student;

import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String description;
    private String category;

    @OneToMany
//    @JoinColumn(name = "student_id")
    private List<Student> students;

}
