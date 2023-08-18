package com.example.projectmid.Repositories;

import com.example.projectmid.Entities.JobPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPortalRepository extends JpaRepository<JobPortal, Integer> {
    public List<JobPortal> findAllByCityEquals(String city);
    public List<JobPortal> findAllByStateEquals(String state);
    public List<JobPortal> findAllByCompanyEquals(String companyName);
}
