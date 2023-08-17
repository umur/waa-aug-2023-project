package com.example.springproject.controller;

import com.example.springproject.entity.*;
import com.example.springproject.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class AdminController {
    private final NewsService newsService;
    private final StudentService studentService;
    private final SurveyService surveyService;
    private final EventService eventService;
    private final JobService jobService;

    ////////////////////////////////// NEWS ///////////////////////////////////////////////////////////
    @PostMapping("/news")
    public ResponseEntity<String> addNews(@RequestBody News news) {
        newsService.add(news);
        return ResponseEntity.ok("post is working correctly");
    }

    @GetMapping("/news")
    public List<News> getNews() {
        return newsService.findAll();
    }
    
    @DeleteMapping("/news/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable int id){
        newsService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping("/news")
    public ResponseEntity<String> updateNews(@RequestBody News news){
        newsService.update(news);
        return ResponseEntity.ok("update is working correctly");

    }

    ////////////////////////////////////////// STUDENT /////////////////////////////////////

    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.add(student);
        return ResponseEntity.ok("post is working correctly");
    }
    @GetMapping("/student/graduation/{gradYear}")
    public List<Student> getStudentByGraduation(@PathVariable String gradYear) {
        return studentService.findByGradution(gradYear);
    }
    //    @GetMapping("/course/{course}")
//    public List<Student> getByCourse(@PathVariable String course) {
//        return studentService.findByCourse(course);
//    }
//    @GetMapping("/location/{city}")
//    public List<Student> getByLocation(@PathVariable String city) {
//        return studentService.findByLocation(city);
//    }
    @GetMapping("/student/industry/{industry}")
    public List<Student> getStudentByIndustry(@PathVariable String industry) {
        return studentService.findByIndustry(industry);
    }

    @GetMapping("/student")
    public List<Student> getStudents() {
        return studentService.findAll();
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        studentService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping("/student")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        studentService.update(student);
        return ResponseEntity.ok("update is working correctly");

    }

    //////////////////////// JOB //////////////////////////////////////


    @GetMapping("/job")
    public List<Job> getJob(){
        return jobService.findAll();
    }

    @PostMapping("/job")
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        jobService.add(job);
        return ResponseEntity.ok("post is working correctly");
    }


    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id){
        jobService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping("/job")
    public ResponseEntity<String> updateJob(@RequestBody Job job){
        jobService.update(job);
        return ResponseEntity.ok("update is working correctly");

    }

    ////////////////////////// SURVEY ///////////////////////////////////

    @PostMapping("/survey")
    public ResponseEntity<String> addSurvey(@RequestBody Survey survey) {
        surveyService.add(survey);
        return ResponseEntity.ok("post is working correctly");
    }


    @GetMapping("/survey")
    public List<Survey> getSurvey() {
        return surveyService.findAll();
    }
    @DeleteMapping("survey/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable int id){
        surveyService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping("/survey")
    public ResponseEntity<String> updateSurvey(@RequestBody Survey survey){
        surveyService.update(survey);
        return ResponseEntity.ok("update is working correctly");

    }

    ///////////////////////////////////// EVENT ///////////////////////////////////////

    @PostMapping("/event")
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        eventService.add(event);
        return ResponseEntity.ok("post is working correctly");
    }
    @PostMapping("event/rsvp/{event_id}")
    public ResponseEntity<String> RSVP(@PathVariable int event_id, @RequestBody Student student){
        eventService.RSVP(event_id, student);
        return ResponseEntity.ok("post is working correctly");

    }
    @GetMapping("/event")
    public List<Event> getEvent() {
        return eventService.findAll();
    }
    @DeleteMapping("event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id){
        eventService.remove(id);
        return ResponseEntity.ok("delete is working correctly");
    }
    @PutMapping("/event")
    public ResponseEntity<String> updateEvent(@RequestBody Event Event){
        eventService.update(Event);
        return ResponseEntity.ok("update is working correctly");

    }
}
