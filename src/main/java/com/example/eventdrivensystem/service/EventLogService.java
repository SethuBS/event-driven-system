package com.example.eventdrivensystem.service;

import com.example.eventdrivensystem.dto.EventDTO;

public interface EventLogService {

    EventDTO publishEvent(EventDTO eventDTO);
}
