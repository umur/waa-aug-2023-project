package org.springers.waa_alumniplatform.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springers.waa_alumniplatform.dto.jobPost.NewJobPost;
import org.springers.waa_alumniplatform.entity.Alumni;
import org.springers.waa_alumniplatform.entity.JobPost;
import org.springers.waa_alumniplatform.exception.EntityNotFound;
import org.springers.waa_alumniplatform.repository.JobPostRepo;
import org.springers.waa_alumniplatform.service.AlumniService;
import org.springers.waa_alumniplatform.service.JobPostService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostServiceImpl implements JobPostService {
    private final JobPostRepo jobPostRepo;
    private final AlumniService alumniService;
    private final ModelMapper modelMapper;
    @Override
    public NewJobPost persist(NewJobPost newJobPost, int alumni_id) {
        Alumni alumni = alumniService.getAlumniById(alumni_id);
        JobPost jobPost = modelMapper.map(newJobPost, JobPost.class);
        jobPost.setPoster(alumni);
        jobPost.setPostedAt(LocalDateTime.now());
        JobPost savedJobPost = jobPostRepo.save(jobPost);
        return modelMapper.map(savedJobPost, NewJobPost.class);
    }

    @Override
    public List<JobPost> getAll() {
        return jobPostRepo.findAll();
    }

    @Override
    public JobPost apply(int jobPostId, int alumniId) {
        Alumni alumni = alumniService.getAlumniById(alumniId);
        JobPost jobPost = getJobPostById(jobPostId);
        jobPost.getApplicants().add(alumni);
        return jobPostRepo.save(jobPost);
    }

    @Override
    public JobPost getJobPostById(int jobPostId) {
        JobPost jobPost = jobPostRepo
                .findById(jobPostId)
                .orElseThrow(()-> new EntityNotFound("Job post not found"));
        return jobPost;
    }

    @Override
    public List<JobPost> getJobPostByState(String state) {
        return jobPostRepo.findJobPostsByCompanyLocationState(state);
    }

    @Override
    public List<JobPost> getJobPostByCity(String city) {
        return jobPostRepo.findJobPostsByCompanyLocationCity(city);
    }

    @Override
    public List<JobPost> getJobPostByCompanyName(String companyName) {
        return jobPostRepo.findJobPostsByCompanyName(companyName);
    }

    @Override
    public JobPost updateOne(Principal principal, int alumniId, int jobPostId, JobPost jobPost) {
        JobPost jobPostInDB = getJobPostById(jobPostId);

        jobPostInDB.setPostedAt(jobPost.getPostedAt());
        jobPostInDB.setIndustry(jobPost.getIndustry());
        jobPostInDB.setCompany(jobPost.getCompany());
        jobPostInDB.setOtherReq(jobPost.getOtherReq());
        jobPostInDB.setPosition(jobPost.getPosition());
        jobPostInDB.setSkills(jobPost.getSkills());


        return jobPostRepo.save(jobPostInDB);

    }

}
