package com.example.springproject.repository;

import com.example.springproject.entity.Event;
import com.example.springproject.entity.Student;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends ListCrudRepository<Student, Integer> {
    List<Student> findByGraduationYear(@Param("graduationYear") String graduationYear);
    List<Student> findByCoursesContaining(String course);
    List<Student> findByAddress_City(String city);
    List<Student> findByIndustry(@Param("industry") String industry);

}
