package org.springers.waa_alumniplatform.controller;

import lombok.RequiredArgsConstructor;
import org.springers.waa_alumniplatform.dto.jobPost.NewJobPost;
import org.springers.waa_alumniplatform.entity.JobPost;
import org.springers.waa_alumniplatform.service.JobPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnus/{alumni_Id}/jobPosts")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/filterByState")
    public ResponseEntity<List<JobPost>> getJobPostByState(@RequestParam String state){
        return ResponseEntity.ok(jobPostService.getJobPostByState(state));
    }

    @GetMapping("/filterByCity")
    public ResponseEntity<List<JobPost>> getJobPostByCity(@RequestParam String city){
        return ResponseEntity.ok(jobPostService.getJobPostByCity(city));
    }

    @GetMapping("/filterByCompanyName")
    public ResponseEntity<List<JobPost>> getJobPostByCompanyName(@RequestParam String companyName){
        return ResponseEntity.ok(jobPostService.getJobPostByCompanyName(companyName));
    }

    @GetMapping("/{jobPost_id}")
    public ResponseEntity<JobPost> getOne(@PathVariable int jobPost_id){
        return ResponseEntity.ok(jobPostService.getJobPostById(jobPost_id));
    }
    @PatchMapping("/{jobPost_id}")
    public ResponseEntity<JobPost> apply(@PathVariable int jobPost_id, @PathVariable int alumni_Id){
        return ResponseEntity.ok(jobPostService.apply(jobPost_id, alumni_Id));
    }
    @PostMapping
    public ResponseEntity<NewJobPost> addOne(@RequestBody NewJobPost jobPost, @PathVariable int alumni_Id ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(jobPostService.persist(jobPost, alumni_Id));
    }

    @GetMapping
    public ResponseEntity<List<JobPost>> getAll(){
        return ResponseEntity.ok(jobPostService.getAll());
    }
}
