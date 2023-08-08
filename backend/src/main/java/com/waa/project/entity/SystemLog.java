package com.waa.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class SystemLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LogLevel logLevel = LogLevel.CAUSUAL;
    @Column(nullable = false, length = 1000)
    private String logMessage;
    @Column(nullable = false)
    private LocalDateTime logTimestamp = LocalDateTime.now();
    @ManyToOne
    private User user;
}
