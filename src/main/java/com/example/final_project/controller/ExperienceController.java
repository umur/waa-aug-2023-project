package com.example.final_project.controller;
import com.example.final_project.dto.ExperienceDto;
import com.example.final_project.service.imp.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.final_project.dto.ResponseMessage;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("user/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<ResponseMessage> add(@RequestBody ExperienceDto experience){
        experienceService.add(experience);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully added experience"));
    }
    @GetMapping
    public ResponseEntity<Object> get(){
        return ResponseEntity.ok(experienceService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> update(@RequestBody ExperienceDto experience, @PathVariable Long id){
        experienceService.updateExperience(experience,id);
        return ResponseEntity.ok(new ResponseMessage(true,"successfully updated experience"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return ResponseEntity.ok(experienceService.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        experienceService.deleteExperience(id);
        return ResponseEntity.ok(new ResponseMessage(true,"removed correctly"));
    }
}
