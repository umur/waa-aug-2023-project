package com.example.projectmid.Services;

import com.example.projectmid.Entities.JobPortal;
import com.example.projectmid.Repositories.JobPortalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPortalService {

    private final JobPortalRepository jobPortalRepository;

    public void save(JobPortal jobPortal) {
        jobPortalRepository.save(jobPortal);
    }

    public void update(Integer id, JobPortal jobPortal) {
        jobPortal.setId(id);
        jobPortalRepository.save(jobPortal);
    }

    public void deleteById(int id) {
        jobPortalRepository.deleteById(id);
    }

    public List<JobPortal> findAll() {
        return jobPortalRepository.findAll();
    }

    public JobPortal findById(int id) {
        return jobPortalRepository.findById(id).orElse(null);
    }
    public List<JobPortal> findAllByCityEquals(String city){
        return jobPortalRepository.findAllByCityEquals(city);
    }
    public List<JobPortal> findAllByStateEquals(String state){
        return jobPortalRepository.findAllByStateEquals(state);
    }
    public List<JobPortal> findAllByCompanyEquals(String companyName){
        return jobPortalRepository.findAllByCompanyEquals(companyName);
    }
}
