package com.example.eventdrivensystem.controller;

import com.example.eventdrivensystem.dto.EventDTO;
import com.example.eventdrivensystem.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventLogService eventLogService;

    @PostMapping
    public ResponseEntity<EventDTO> publishEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventLogService.publishEvent(eventDTO));
    }
}
