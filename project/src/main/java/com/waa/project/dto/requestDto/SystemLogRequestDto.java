package com.waa.project.dto.requestDto;

import com.waa.project.entity.LogLevel;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SystemLogRequestDto {
    private LogLevel logLevel = LogLevel.CAUSUAL;
    private String logMessage;
}
