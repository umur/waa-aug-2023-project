package com.example.final_project.service.imp;

import com.example.final_project.dto.NewsDto;
import com.example.final_project.dto.NewsDto;
import com.example.final_project.entity.News;
import com.example.final_project.entity.News;
import com.example.final_project.entity.User;
import com.example.final_project.repository.NewsRepo;
import com.example.final_project.repository.UserRepo;
import com.example.final_project.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
   private final  NewsRepo newsRepo;
   private final ModelMapper modelMapper;
   private final UserRepo userRepo;
    @Override
    public List<NewsDto> getAllNews() {
        List<NewsDto>dtoList = new ArrayList<>();
        List<News> newsList = newsRepo.findAll();   //entity list
        System.out.println(newsList);
        newsList.forEach(entity ->{
            if (!entity.isDeleted()){
                NewsDto dto  = modelMapper.map(entity,NewsDto.class);
                dtoList.add(dto);}
        });
        return dtoList;
    }

    @Override
    public NewsDto getNewsById(Long id) {
        NewsDto dto = null;
        News entity = newsRepo.findById(id).get(); // findBy returns an optional
        if (!entity.isDeleted()){
            dto = modelMapper.map(entity,NewsDto.class);}
        return dto;
    }

    @Override
    public void delete(Long id) {
        Optional<News> entity = newsRepo.findById(id);
        if(entity.isPresent()){
            entity.get().setDeleted(true);
        newsRepo.save(entity.get());}

    }

    @Override
    public void save(NewsDto newsDto) {
        News entity = modelMapper.map(newsDto,News.class);
        newsRepo.save(entity);

    }

    @Override
    public void update(NewsDto newsDto) {
        // news entity = newsRepo.findById(newsDto.getId()).get(); //findBy returns an optional
        NewsDto dbDto = getNewsById(newsDto.getId());  //dto from getnewsById method above
        if (newsDto.getNewsPoster()!=null)
            dbDto.setNewsPoster(newsDto.getNewsPoster());
        if (newsDto.getTitle()!=null)
            dbDto.setTitle(newsDto.getTitle());
        if (newsDto.getDescription()!=null)
            dbDto.setDescription(newsDto.getDescription());
        if (newsDto.getPostedOn()!=null)
            dbDto.setPostedOn(newsDto.getPostedOn());

        save(dbDto);


    }


    public void save2(NewsDto dto, Long userId) {

        News entity = modelMapper.map(dto,News.class);
        User newsPoster = userRepo.findById(userId).get();
        entity.setPostedOn(LocalDate.now());
        entity.setNewsPoster(newsPoster);
        newsRepo.save(entity);

    }
}
