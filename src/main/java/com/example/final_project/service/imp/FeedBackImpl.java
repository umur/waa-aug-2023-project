package com.example.final_project.service.imp;

import com.example.final_project.dto.FeedBackDto;

import com.example.final_project.entity.Feedback;
import com.example.final_project.entity.User;
import com.example.final_project.repository.FeedbackRepo;
import com.example.final_project.repository.UserRepo;
import com.example.final_project.service.FeedBackService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedBackImpl implements FeedBackService {
   private final FeedbackRepo feedbackRepo;
  private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<FeedBackDto> getAllFeedBack() {
        List<FeedBackDto>dtoList = new ArrayList<>();
        List<Feedback> FeedBackList = feedbackRepo.findAll();   //entity list
        FeedBackList.forEach(entity ->{
            if (!entity.isDeleted()){
                FeedBackDto dto  = modelMapper.map(entity,FeedBackDto.class);
                dtoList.add(dto);}
        });
        return dtoList;
    }

    @Override
    public FeedBackDto getFeedBackById(Long id) {
        FeedBackDto dto = null;
        Feedback entity = feedbackRepo.findById(id).get(); // findBy returns an optional
        if (!entity.isDeleted()){
            dto = modelMapper.map(entity,FeedBackDto.class);}
        return dto;
    }

    @Override
    public void delete(Long id) {
        Optional<Feedback> entity = feedbackRepo.findById(id);
        if(entity.isPresent()){
            entity.get().setDeleted(true);
        feedbackRepo.save(entity.get());}

    }

    @Override
    public void save(FeedBackDto FeedBackDto) {
        Feedback entity = modelMapper.map(FeedBackDto,Feedback.class);
        feedbackRepo.save(entity);

    }

    @Override
    public void update(FeedBackDto FeedBackDto) {
        // FeedBack entity = FeedBackRepo.findById(FeedBackDto.getId()).get(); //findBy returns an optional

        FeedBackDto dbDto = getFeedBackById(FeedBackDto.getId());  //dto from getFeedBackById method above
        if (FeedBackDto.getComment()!=null)
            dbDto.setComment(FeedBackDto.getComment());
        if (FeedBackDto.getCommenter()!=null)
            dbDto.setCommenter(FeedBackDto.getCommenter());

        save(dbDto);

}

/////////////////////////////////////////////////

    @Override
    public void save2(FeedBackDto dto, Long userId) {
        Feedback entity = modelMapper.map(dto,Feedback.class);
        User commenter = userRepo.findById(userId).get();
       // Optional<User> commenter = userRepo.findById(userId);
        entity.setCommenter(commenter);
        feedbackRepo.save(entity);
    }

    public void update2(FeedBackDto dto, Long userId){
        Feedback entity = feedbackRepo.findById(dto.getId()).get();
        //User commenter = userRepo.findById(userId).get();
        //entity.setCommenter(commenter);
        if (dto.getComment()!=null)
            entity.setComment(dto.getComment());

        feedbackRepo.save(entity);
    }




}
