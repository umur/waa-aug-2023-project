package com.example.springproject.service;
import com.example.springproject.entity.Application;
import com.example.springproject.repository.ApplicationRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("aps")
@Component
@Transactional
public class ApplicationService {


    private final ApplicationRepo apRepo;


    public Application addApplication(Application a){
        return apRepo.save(a);
    }
    public List<Application> getAllApplications(){
        return apRepo.findAll();
    }


    public List<Application> getApplicationsOfStudent(Long id){
        return apRepo.getApplicationsByStudent_IdIsAndIsDeleted(id, false);
    }

    public Application getApplicationById(Long id){
        return apRepo.getApplicationByAppIdIsAndIsDeleted(id, false);
    }

    public void deleteApplication(Long id, Long id2){
        apRepo.deleteApplication(id, id2);
    }

}
