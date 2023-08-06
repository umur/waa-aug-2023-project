package com.example.projectmid.Services;

import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Repositories.AlumniRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlumniService {

    private final AlumniRepository alumniRepository;

    public void save(Alumni alumni) {
        alumniRepository.save(alumni);
    }

    public void update(Integer id, Alumni alumni) {
        alumniRepository.save(alumni);
    }

    public void deleteById(int id) {
        alumniRepository.deleteById(id);
    }

    public List<Alumni> findAll() {
        return alumniRepository.findAll();
    }

    public Alumni findById(int id) {
        return alumniRepository.findById(id).orElse(null);
    }

    public List<Alumni> findAllByGraduationYear(int graduationYear){
         return alumniRepository.findAllByGraduationYear(graduationYear);
    }

    public List<Alumni> findAllByLocationEquals(String location){
         return alumniRepository.findAllByLocationEquals(location);
    }
}