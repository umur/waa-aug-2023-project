package com.waa.project.dto.requestDto;

import com.waa.project.entity.JobAdvertisement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobPostingDto {
    private long id;
    private String title;
    private String description;
    private String state;
    private String city;
    private String companyName;

    public static JobPostingDto fromJobAdvertissement(JobAdvertisement jobAdvertisement){
        JobPostingDto jobPostingDto = new JobPostingDto();
        jobPostingDto.setId(jobAdvertisement.getId());
        jobPostingDto.setTitle(jobAdvertisement.getTitle());
        jobPostingDto.setCity(jobAdvertisement.getCity());
        jobPostingDto.setState(jobAdvertisement.getState());
        jobPostingDto.setDescription(jobAdvertisement.getDescription());
        jobPostingDto.setCompanyName(jobAdvertisement.getCompanyName());
        return jobPostingDto;
    }
}
