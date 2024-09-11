package com.example.eventdrivensystem.map;

import com.example.eventdrivensystem.dto.EventDTO;
import com.example.eventdrivensystem.model.EventLog;

public class Mapper {

    public static EventLog map(EventDTO eventDTO) {
        if (eventDTO == null) {
            return null;
        }

        return EventLog.builder()
                .id(eventDTO.getId())
                .eventType(eventDTO.getEventType())
                .eventSource(eventDTO.getEventSource())
                .eventData(eventDTO.getEventData())
                .eventTimestamp(eventDTO.getEventTimestamp())
                .build();
    }

    public static EventDTO map(EventLog eventLog) {
        if (eventLog == null) {
            return null;
        }

        return EventDTO.builder()
                .id(eventLog.getId())
                .eventType(eventLog.getEventType())
                .eventSource(eventLog.getEventSource())
                .eventData(eventLog.getEventData())
                .eventTimestamp(eventLog.getEventTimestamp())
                .build();
    }
}
