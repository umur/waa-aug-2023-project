package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.Alumni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlumniRepo extends JpaRepository<Alumni, Integer> {
    Optional<Alumni> findUserById(int alumniId);
    List<Alumni> findAllByEduInOurUniGradYear(int year);
    List<Alumni> findAllByEduInOurUniDept(String dept);
    List<Alumni> findAllByIndustryName(String industry);
}
