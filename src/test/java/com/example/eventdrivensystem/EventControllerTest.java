package com.example.eventdrivensystem;

import com.example.eventdrivensystem.dto.EventDTO;
import com.example.eventdrivensystem.service.EventLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @MockBean
    private EventLogService eventLogService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPublishEvent() throws Exception {
        var eventDTO = new EventDTO();
        eventDTO.setId(1L);
        eventDTO.setEventType("LOG");
        eventDTO.setEventSource("RabbitMQ");
        eventDTO.setEventData("User login event");
        eventDTO.setEventTimestamp(LocalDateTime.now());

        ObjectMapper objectMapper = new ObjectMapper();

        // Mock service
        Mockito.doNothing().when(eventLogService).publishEvent(Mockito.any(EventDTO.class));

        // Test controller
        mockMvc.perform(post("/api/events/publish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(eventDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("Event published successfully"));
    }
}
