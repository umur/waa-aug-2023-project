package com.example.final_project.service;

import com.example.final_project.dto.CreateFeedbackDto;
import com.example.final_project.dto.FeedBackDto;

import java.util.List;

public interface FeedBackService {
    public List<FeedBackDto> getAllFeedBack();
    public FeedBackDto getFeedBackById(Long id);
    public void save(FeedBackDto dto);
    public void delete(Long id);
    public void update(FeedBackDto FeedBackDto);

   public  void save2(FeedBackDto dto, Long userId);

    public void update2(FeedBackDto dto, Long userId);
}
