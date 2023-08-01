package com.example.demo.service.impl;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EventRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private  EventRepo eventRepo;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;



    @Override
    public EventDto createEvent(long userId, EventDto eventDto) {
        User user =userRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with ID: " + userId);
        }
        Event event = modelMapper.map(eventDto, Event.class);
        event.setOrganizer(user);
        Event savedEvent = eventRepo.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    @Override
    public EventDto updateEvent(long userId, long eventId, EventDto eventDto) throws IllegalAccessException {
        Event existingEvent = eventRepo.findById(eventId).orElse(null);
        if (existingEvent == null) {
            throw new ResourceNotFoundException("Event not found with ID: " + eventId);
        }
        if (existingEvent.getOrganizer().getId() != userId) {
            throw new IllegalAccessException("You are not authorized to update this event.");
        }

        existingEvent.setTitle(eventDto.getTitle());
        existingEvent.setDescription(eventDto.getDescription());
        existingEvent.setDate(eventDto.getDate());
        existingEvent.setLocation(eventDto.getLocation());

        Event updatedEvent = eventRepo.save(existingEvent);
        return modelMapper.map(updatedEvent, EventDto.class);
    }

    @Override
    public void deleteEvent(long eventId) {
        Event existingEvent = eventRepo.findById(eventId).orElse(null);
        if (existingEvent == null) {
           throw new ResourceNotFoundException("Event not found with ID: " + eventId);
        }
        existingEvent.setDeleted(true);
        eventRepo.save(existingEvent);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepo.findAllByIsDeletedFalse(); // Filter out deleted events
        return events.stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(long eventId) {
        Event event = eventRepo.findByIdAndIsDeletedFalse(eventId); // Find by ID and ensure it's not deleted
        if (event == null) {
            throw new ResourceNotFoundException("Event not found with ID: " + eventId);
        }
        return modelMapper.map(event, EventDto.class);
    }
}
