package com.example.springproject.Aspect;


import com.example.springproject.entity.Log;
import com.example.springproject.repository.LogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
@Qualifier("los")
public class LogService {

    private final LogRepo loRepo;


    public Log addLog(Log l){
        return loRepo.save(l);
    }

    public List<Log> getLogsByDateAndTime(LocalDateTime dt){
        return loRepo.getLogsByTimeIs(dt);
    }

    public List<Log> getLogsByUser(Long id){
        return loRepo.getLogsByUser_IdIs(id);
    }

    public List<Log> getLogsByUserAndDateAndTime(Long id, LocalDateTime dt){
        return loRepo.getLogsByUser_IdIsAndTimeIs(id, dt);
    }
}
