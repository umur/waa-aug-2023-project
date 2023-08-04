package com.example.final_project.controller;

import com.example.final_project.dto.FeedBackDto;
import com.example.final_project.service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor

public class FeedBackController {
   private final FeedBackService feedBackService;
   @GetMapping
   List<FeedBackDto> getAll(){
       return feedBackService.getAllFeedBack();
   }
    @GetMapping("/{id}")
   FeedBackDto getById(@PathVariable Long id){
       return feedBackService.getFeedBackById(id);
   }
   @PostMapping
   public ResponseEntity<String> save(@RequestBody FeedBackDto dto){
       feedBackService.save(dto);
       return ResponseEntity.ok().body("created successfully");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody FeedBackDto dto){
       feedBackService.update(dto);
        return ResponseEntity.ok().body("edited successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
       feedBackService.delete(id);
        return ResponseEntity.ok().body("deleted successfully");
    }





    @PostMapping("/{userId}")
    public ResponseEntity<String> save2(@RequestBody FeedBackDto dto, @PathVariable Long userId){
        feedBackService.save2(dto, userId);
        return ResponseEntity.ok().body("created successfully");
    }

    /***
    @PutMapping("/{userId}")
    void update2(@RequestBody FeedBackDto dto, @PathVariable Long userId){
        feedBackService.update2(dto, userId);
    }
    @DeleteMapping("/{userId}/{id}")
    void delete2(@PathVariable Long id){
        feedBackService.delete(id);
    }
    **/
}
