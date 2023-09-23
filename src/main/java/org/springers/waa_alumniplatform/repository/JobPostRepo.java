package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostRepo extends JpaRepository<JobPost, Integer> {
    List<JobPost> findJobPostsByCompanyLocationState(String state);
    List<JobPost> findJobPostsByCompanyLocationCity(String city);
    List<JobPost> findJobPostsByCompanyName(String companyName);
}
