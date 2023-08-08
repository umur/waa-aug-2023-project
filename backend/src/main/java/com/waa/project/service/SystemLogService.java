package com.waa.project.service;

import com.waa.project.dto.requestDto.SystemLogRequestDto;

import java.util.List;

public interface SystemLogService {
    void addSystemLog(SystemLogRequestDto systemLogRequestDto,Long id);
    List<SystemLogRequestDto> getSystemLogs();
}
