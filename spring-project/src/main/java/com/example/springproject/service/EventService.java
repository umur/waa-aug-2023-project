package com.example.springproject.service;

import com.example.springproject.entity.Event;
import com.example.springproject.entity.Job;
import com.example.springproject.entity.Student;

import java.util.List;

public interface EventService {
    public void add(Event event);
    public void remove(int id);

    public void update(Event event);

    public void RSVP (int id, Student student);

    List<Event> findAll();
	public Event getById(int id);
}
