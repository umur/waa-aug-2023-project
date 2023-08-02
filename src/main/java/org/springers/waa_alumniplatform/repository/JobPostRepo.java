package org.springers.waa_alumniplatform.repository;

import org.springers.waa_alumniplatform.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepo extends JpaRepository<JobPost, Integer> {
}
