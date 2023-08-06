package com.example.final_project.service.imp;
import com.example.final_project.dto.ProfileDto;
import com.example.final_project.entity.Profile;
import com.example.final_project.entity.User;
import com.example.final_project.repository.ProfileRepo;
import com.example.final_project.repository.UserRepo;
import com.example.final_project.repository.UserRepository;
import com.example.final_project.service.IProfileService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfileService implements IProfileService{
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void add(ProfileDto profile, HttpServletRequest request) {
        String email = (String)request.getAttribute("email");
        User user = userRepo.findUserByEmail(email).get();
        Profile profileP = modelMapper.map(profile,Profile.class);
        profileP.setUser(user);
        profileRepo.save(profileP);
    }

    @Override
    public List<ProfileDto> findAll() {
        return null;
    }

    @Override
    public ProfileDto findById(HttpServletRequest request) {
        String email = (String)request.getAttribute("email");
        User user = userRepo.findUserByEmail(email).get();
        Profile profile = profileRepo.findProfileByUserId(user.getId());
        ProfileDto profileP = modelMapper.map(profile,ProfileDto.class);
        return profileP;
    }

    @Override
    public void update(ProfileDto profileDto, HttpServletRequest request) {
        String email = (String)request.getAttribute("email");
        User user = userRepo.findUserByEmail(email).get();
        Profile profileP = modelMapper.map(profileDto,Profile.class);
        profileP.setUser(user);
        Profile profile = profileRepo.findProfileByUserId(user.getId());

    }

    @Override
    public void delete(HttpServletRequest request) {

    }
}
