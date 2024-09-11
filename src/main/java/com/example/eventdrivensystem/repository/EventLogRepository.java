package com.example.eventdrivensystem.repository;

import com.example.eventdrivensystem.model.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLogRepository extends JpaRepository<EventLog, Long> {
}
