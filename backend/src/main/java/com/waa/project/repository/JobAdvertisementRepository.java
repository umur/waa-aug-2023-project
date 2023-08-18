package com.waa.project.repository;

import com.waa.project.entity.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long>, JpaSpecificationExecutor<JobAdvertisement> {
    List<JobAdvertisement> findAllByStudentId(Long studentId);
}
