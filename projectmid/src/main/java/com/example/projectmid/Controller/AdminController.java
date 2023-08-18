package com.example.projectmid.Controller;

import com.example.projectmid.Entities.Admin;
import com.example.projectmid.Services.AdminService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//[general] admin will do crud on almost every enitiy [security]
//comment: make the adminstroator publich news,[security] + alumni can get a list of news.
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @PostMapping
    public void createAdmin(@RequestBody Admin admin){
        adminService.save(admin);
    }
    //update
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Admin admin){
        adminService.update(id, admin);
    }
    //Delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        adminService.deleteById(id);
    }
    @GetMapping
    public List<Admin> findAll(){
        return adminService.findAll();
    }
    @GetMapping("/{id}")
    public Admin findById(@PathVariable int id){
        return adminService.findById(id);
    }
    @GetMapping("/deactivate/{alumni_id}")
    public void deactivateAlumni(@PathVariable int alumni_id){
         adminService.deactivateAlumni(alumni_id);
    }

}
