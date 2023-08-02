package com.example.demo.service.impl;

import com.example.demo.dto.EventParticipantDto;
import com.example.demo.entity.EventParticipant;
import com.example.demo.entity.User;
import com.example.demo.repository.EventParticipantRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.EventParticipantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventParticipantServiceImpl implements EventParticipantService {
    @Autowired
    private EventParticipantRepo eventParticipantRepository;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EventParticipantDto createEvent(long userId, EventParticipantDto eventParticipantDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found."));

        EventParticipant eventParticipant = modelMapper.map(eventParticipantDto, EventParticipant.class);
        eventParticipant.setUser(user);

        EventParticipant savedEventParticipant = eventParticipantRepository.save(eventParticipant);

        return modelMapper.map(savedEventParticipant, EventParticipantDto.class);
    }

//    @Override
//    public EventParticipantDto updateEvent(long userId, long eventId, EventParticipantDto eventParticipantDto) throws IllegalAccessException {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User with ID " + userId + " not found."));
//
//        EventParticipant eventParticipant = eventParticipantRepository.findById(eventId)
//                .orElseThrow(() -> new IllegalArgumentException("Event Participant with ID " + eventId + " not found."));
//
//        if (eventParticipant.getUser().getId() != userId) {
//            throw new IllegalAccessException("User does not have permission to update this event participant.");
//        }
//
//        eventParticipant.setEvent(eventParticipantDto.getEvent());
//        // Update other fields as needed
//
//        EventParticipant updatedEventParticipant = eventParticipantRepository.save(eventParticipant);
//
//        return modelMapper.map(updatedEventParticipant, EventParticipantDto.class);
//    }

    @Override
    public void deleteEventParticipant(long userId, long eventId) {
        EventParticipant eventParticipant = eventParticipantRepository.findByUserIdAndEventId(userId, eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event Participant not found for User ID " + userId + " and Event ID " + eventId));

        eventParticipant.setDeleted(true); // Soft delete the participant's reservation
        eventParticipantRepository.save(eventParticipant);
    }

    @Override
    public List<EventParticipantDto> getAllEventParticipants() {
        List<EventParticipant> eventParticipants = eventParticipantRepository.findAll();
        return eventParticipants.stream()
                .map(eventParticipant -> modelMapper.map(eventParticipant, EventParticipantDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public EventParticipantDto getEventParticipantsByEventId(long eventId) {
        EventParticipant eventParticipant = eventParticipantRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event Participant with ID " + eventId + " not found."));
        return modelMapper.map(eventParticipant, EventParticipantDto.class);
    }
}
