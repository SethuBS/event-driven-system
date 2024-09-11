package com.example.eventdrivensystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EventDTO {
    private Long id;
    private String eventType;
    private String eventSource;
    private String eventData;
    private LocalDateTime eventTimestamp;
}
