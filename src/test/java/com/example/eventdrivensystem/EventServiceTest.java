package com.example.eventdrivensystem;

import com.example.eventdrivensystem.dto.EventDTO;
import com.example.eventdrivensystem.service.EventLogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private EventLogService eventLogService;

    @Test
    public void testPublishEvent() {
        // Arrange
        EventDTO eventDTO = new EventDTO(1L, "LOG", "RabbitMQ", "User login event", LocalDateTime.now());

        // Act
        eventLogService.publishEvent(eventDTO);

        // Assert
        verify(rabbitTemplate).convertAndSend("eventExchange", "eventKey", eventDTO);
    }
}
