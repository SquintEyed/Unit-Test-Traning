package org.example.controller;

import org.example.dto.EventDto;
import org.example.dto.EventDtoBuilder;
import org.example.entity.Event;
import org.example.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventControllerTest {

    private final Long ID = 1L;

    @Mock
    private EventService eventService;

    @Mock
    private EventDtoBuilder eventDtoBuilder;

    @InjectMocks
    private EventController eventController;


    @Test
    void getEventById() {

        Event event = mock(Event.class);
        when(eventService.findEvent(ID)).thenReturn(event);
        EventDto eventDto = mock(EventDto.class);
        when(eventDtoBuilder.fromEvent(event)).thenReturn(eventDto);

        EventDto actualEvent = eventController.getEventById(ID);

        assertNotNull(actualEvent);
        assertEquals(actualEvent, eventDto);
        verify(eventService).findEvent(ID);
        verify(eventDtoBuilder).fromEvent(event);

    }

    @Test
    void saveEvent() {

      Event event = mock(Event.class);
      EventDto eventDto = mock(EventDto.class);
      when(eventDtoBuilder.fromEventDto(eventDto)).thenReturn(event);

      eventController.saveEvent(eventDto);

      verify(eventService).saveEvent(event);
      verify(eventDtoBuilder).fromEventDto(eventDto);
    }
}