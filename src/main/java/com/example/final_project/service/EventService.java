package com.example.final_project.service;

import com.example.final_project.dto.EventDto;
import com.example.final_project.dto.FeedBackDto;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();
    EventDto getEventById(Long id);
    public void deleteEvent(Long id);
    public void save(EventDto event);
    public void update(EventDto event);

    public void save2(EventDto dto, Long userId);
}
