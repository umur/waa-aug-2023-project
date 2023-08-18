package com.example.projectmid.Services;

import com.example.projectmid.Entities.Admin;
import com.example.projectmid.Entities.Alumni;
import com.example.projectmid.Repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private List<Integer> deactivatedAlumnies = new ArrayList<>();
    private final AdminRepository adminRepository;

    public void save(Admin admin){
        adminRepository.save(admin);
    }

    public void update(Integer id,Admin admin){
        var oldAdmin = adminRepository.findById(id).orElse(null);
        oldAdmin.setNewsList(admin.getNewsList());
        adminRepository.save(oldAdmin);

    }

    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    public void deactivateAlumni(int alumniId) {
        deactivatedAlumnies.add(alumniId);
    }
}
