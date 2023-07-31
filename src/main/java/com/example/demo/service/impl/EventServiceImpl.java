package com.example.demo.service.impl;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;
import com.example.demo.repository.EventRepo;
import com.example.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepo eventRepo;
    private final ModelMapper modelMapper;


    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        Event savedEvent = eventRepo.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    @Override
    public EventDto updateEvent(Integer eventId, EventDto eventDto) {
        Event existingEvent = eventRepo.findById(eventId).orElse(null);
        if (existingEvent == null) {
            return null;
        }


        existingEvent.setTitle(eventDto.getTitle());
        existingEvent.setDescription(eventDto.getDescription());
        existingEvent.setDate(eventDto.getDate());
        existingEvent.setLocation(eventDto.getLocation());
//        existingEvent.setOrganizer(eventDto.getOrganizer());

        Event updatedEvent = eventRepo.save(existingEvent);
        return modelMapper.map(updatedEvent, EventDto.class);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        Event existingEvent = eventRepo.findById(eventId).orElse(null);
        if (existingEvent == null) {
//            throw new NotFoundException("Event not found with ID: " + eventId);
            return;
        }

        eventRepo.delete(existingEvent);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepo.findAll();
        return events.stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventDto getEventById(Integer eventId) {
        Event event = eventRepo.findById(eventId).orElse(null);
        if (event == null) {
//            throw new NotFoundException("Event not found with ID: " + eventId);
            return null;
        }


        return modelMapper.map(event, EventDto.class);
    }
}
