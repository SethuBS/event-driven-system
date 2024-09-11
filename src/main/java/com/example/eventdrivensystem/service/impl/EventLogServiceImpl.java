package com.example.eventdrivensystem.service.impl;

import com.example.eventdrivensystem.dto.EventDTO;
import com.example.eventdrivensystem.map.Mapper;
import com.example.eventdrivensystem.repository.EventLogRepository;
import com.example.eventdrivensystem.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventLogServiceImpl implements EventLogService {

    @Autowired
    private EventLogRepository eventLogRepository;

    @Override
    public EventDTO publishEvent(EventDTO eventDTO) {
        var newEventLog = Mapper.map(eventDTO);
        var savedEventLog = eventLogRepository.save(newEventLog);
        return Mapper.map(savedEventLog);
    }
}
