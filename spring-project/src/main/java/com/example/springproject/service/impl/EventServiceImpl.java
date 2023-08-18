package com.example.springproject.service.impl;

import com.example.springproject.entity.Event;
import com.example.springproject.entity.Job;
import com.example.springproject.entity.Student;
import com.example.springproject.repository.EventRepo;
import com.example.springproject.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepo eventRepo;
    @Override
    public void add(Event event) {
        eventRepo.save(event);
    }

    @Override
    public void remove(int id) {
        Optional<Event> event = eventRepo.findById(id);
        if(event.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            eventRepo.delete(event.get());
        }

    }



    @Override
    public void update(Event event) {
        remove(event.getId());
        add(event);
    }

    @Override
    public void RSVP(int id, Student student) {
        Optional<Event> eventO = eventRepo.findById(id);
        if(eventO.isEmpty()){
            throw new IllegalArgumentException();
        }
        else{
            Event event = eventO.get();
            event.getStudents().add(student);
            update(event);
        }
    }

    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

	@Override
	public Event getById(int id) {
		Optional<Event> event = eventRepo.findById(id);
		if(event.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return event.get();
	}
}
