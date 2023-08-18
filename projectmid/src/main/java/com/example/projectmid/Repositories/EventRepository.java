package com.example.projectmid.Repositories;

import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query("select e.attendentList from Event e JOIN Alumni a on e.id =?1")
    public List<Alumni> findAlumniByEvent(int event_id);

}
