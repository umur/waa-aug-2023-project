package org.springers.waa_alumniplatform.service;

import org.springers.waa_alumniplatform.dto.jobPost.NewJobPost;
import org.springers.waa_alumniplatform.entity.JobPost;

import java.util.List;

public interface JobPostService {
    NewJobPost persist(NewJobPost jobPost, int alumni_id);

    List<JobPost> getAll();

    JobPost apply(int jobPostId, int alumniId);

    JobPost getJobPostById(int jobPostId);

    List<JobPost> getJobPostByState(String state);
    List<JobPost> getJobPostByCity(String state);

    List<JobPost> getJobPostByCompanyName(String companyName);
}
