package com.example.projectmid.Repositories;

import com.example.projectmid.Entities.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Integer> {
    public List<Alumni> findAllByGraduationYear(int graduationyear);
    public List<Alumni> findAllByLocationEquals(String location);

}
