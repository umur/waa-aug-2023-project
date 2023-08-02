package com.example.demo.dto;

import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventParticipantDto {
    public long id;
    private Event event;
    private User user;
}
