package com.waa.project.repository;

import com.waa.project.entity.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog,Long> {
}
