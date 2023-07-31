package com.waa.project.service.impl;

import com.waa.project.dto.requestDto.SystemLogRequestDto;
import com.waa.project.entity.SystemLog;
import com.waa.project.repository.SystemLogRepository;
import com.waa.project.service.SystemLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SystemLogServiceImpl implements SystemLogService {
    private final SystemLogRepository systemLogRepository;

    @Override
    public void addSystemLog(SystemLogRequestDto systemLogRequestDto) {
        SystemLog systemLog = new SystemLog();
        systemLog.setLogLevel(systemLogRequestDto.getLogLevel());
        systemLog.setLogMessage(systemLogRequestDto.getLogMessage());
        systemLogRepository.save(systemLog);
    }

    @Override
    public List<SystemLogRequestDto> getSystemLogs() {
        var entityList = systemLogRepository.findAll();
        List<SystemLogRequestDto> dtoList = new ArrayList<>();
        SystemLogRequestDto dto = new SystemLogRequestDto();
        entityList.forEach(entity -> {
            dto.setLogLevel(entity.getLogLevel());
            dto.setLogMessage(entity.getLogMessage());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
