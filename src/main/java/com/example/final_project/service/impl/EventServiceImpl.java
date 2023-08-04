package com.example.final_project.service.impl;

import com.example.final_project.dto.EventDto;
import com.example.final_project.dto.FeedBackDto;
import com.example.final_project.entity.Event;
import com.example.final_project.entity.Feedback;
import com.example.final_project.entity.User;
import com.example.final_project.repository.EventRepo;
import com.example.final_project.repository.UserRepo;
import com.example.final_project.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepo eventRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    @Override
    public List<EventDto> getAllEvents() {
        List<EventDto>dtoList = new ArrayList<>();
        System.out.println("in serviceImpl");
       // List<Event> eventList = eventRepo.findAll();   //entity list
        var eventList = eventRepo.findAll();
        System.out.println(eventList);

        eventList.forEach(entity ->{

            if (!entity.isDeleted()){
            EventDto dto  = modelMapper.map(entity,EventDto.class);
            dtoList.add(dto);
            }

        });

        return dtoList;
    }

    @Override
    public EventDto getEventById(Long id) {
        EventDto dto = null;
        Event entity = eventRepo.findById(id).get(); // findBy returns an optional
        if (!entity.isDeleted()){
         dto = modelMapper.map(entity,EventDto.class);}
        return dto;
    }

    @Override
    public void deleteEvent(Long id) {
        Optional<Event> entity = eventRepo.findById(id);
        if(entity.isPresent()){
            entity.get().setDeleted(true);
            eventRepo.save(entity.get());}

    }

    @Override
    public void save(EventDto eventDto) {
        Event entity = modelMapper.map(eventDto,Event.class);
       // entity.setPostedDate(LocalDate.now());
        eventRepo.save(entity);

    }

    @Override
    public void update(EventDto eventDto) {
       // Event entity = eventRepo.findById(eventDto.getId()).get(); //findBy returns an optional
        EventDto dbDto = getEventById(eventDto.getId());  //dto from getEventById method above
        if (eventDto.getEventOrganizer()!=null)
            dbDto.setEventOrganizer(eventDto.getEventOrganizer());
        if (eventDto.getEventType()!=null)
            dbDto.setEventType(eventDto.getEventType());
        if (eventDto.getPostedDate()!=null)
            dbDto.setPostedDate(eventDto.getPostedDate());

        save(dbDto);


    }

    @Override
    public void save2(EventDto dto, Long userId) {

            Event entity = modelMapper.map(dto,Event.class);
            User organizer = userRepo.findById(userId).get();
            entity.setPostedDate(LocalDate.now());
            entity.setEventOrganizer(organizer);
            eventRepo.save(entity);

    }
}
