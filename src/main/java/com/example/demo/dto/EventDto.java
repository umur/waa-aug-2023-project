package com.example.demo.dto;

import com.example.demo.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
public class EventDto {
    private long id;
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    private String title;
    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 1000, message = "Description must be between 5 and 1000 characters")
    private String description;
    @NotBlank(message = "Date is required")
    private LocalDate date;
    @NotBlank(message = "Location is required")
    private String location;
    @NotBlank(message = "Organizer is required")
    private User organizer;
    private boolean isDeleted;

}
