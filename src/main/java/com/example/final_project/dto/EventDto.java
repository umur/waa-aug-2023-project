package com.example.final_project.dto;

import com.example.final_project.entity.User;
import com.example.final_project.enums.EventType;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EventDto {

    private Long id;
    private EventType eventType;
    private List<User> attendees;
    private User eventOrganizer;
    private LocalDate postedDate;
    private boolean deleted = false;

}
