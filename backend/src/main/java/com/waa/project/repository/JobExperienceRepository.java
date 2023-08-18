package com.waa.project.repository;


import com.waa.project.entity.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobExperienceRepository extends JpaRepository<JobExperience, Long> {
}
