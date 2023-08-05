package com.example.projectmid.Controller;

import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Entities.JobPortal;
import com.example.projectmid.Services.JobPortalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//comment /// make the alumni post jobs security;;;
@RestController
@AllArgsConstructor
@RequestMapping("/api/jobportal")
public class JobPortalController {
    private final JobPortalService jobPortalService;

    @PostMapping
    public void createJobPortal(@RequestBody JobPortal jobPortal){
        jobPortalService.save(jobPortal);
    }

    //id job will be passed
    @PutMapping("/{job_id}")
    public void update(@PathVariable int job_id, @RequestBody JobPortal jobPortal){
        jobPortalService.update(job_id, jobPortal);
    }
    //id job will be passed
    /*@PutMapping("/{job_id}")
    public void update(@PathVariable int job_id, @RequestBody JobPortal jobPortal, @RequestBody Alumni alumni){
        if(alumni.getId() ==jobPortal.getAlumni().getId())
            jobPortalService.update(job_id, jobPortal);
    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        jobPortalService.deleteById(id);
    }

    @GetMapping
    public List<JobPortal> findAll(){
        return jobPortalService.findAll();
    }

    @GetMapping("/{id}")
    public JobPortal findById(@PathVariable int id){
        return jobPortalService.findById(id);
    }
    @GetMapping("/by-city/{city}")
    public List<JobPortal> findAllByCityEquals(@PathVariable String city){
        return jobPortalService.findAllByCityEquals(city);
    }
    @GetMapping("/by-state/{state}")
    public List<JobPortal> findAllByStateEquals(@PathVariable String state){
        return jobPortalService.findAllByStateEquals(state);
    }
    @GetMapping("/by-companyname/{companyName}")
    public List<JobPortal> findAllByCompanyEquals(@PathVariable String companyName){
        return jobPortalService.findAllByCompanyEquals(companyName);
    }
}
