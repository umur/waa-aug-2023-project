package com.waa.project.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponseDto<T> {
    private String status;
    private String message;
    private T data;

    public CustomResponseDto(String status,String message,T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
