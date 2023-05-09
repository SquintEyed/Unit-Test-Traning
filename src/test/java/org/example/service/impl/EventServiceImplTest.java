package org.example.service.impl;

import org.example.entity.Event;
import org.example.repositories.EventRepository;
import org.example.repositories.impl.EventRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    private final Long ID = 1L;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;


    @Test
    void findEvent_ShouldCallRepo() {

        Event event = mock(Event.class);
        when(eventRepository.findById(ID)).thenReturn(event);

        Event actualEvent = eventService.findEvent(ID);

        assertNotNull(actualEvent);
        assertEquals(actualEvent, event);
        verify(eventRepository).findById(ID);
    }

    @Test
    void saveEvent_ShouldCallRepo() {

        Event event = mock(Event.class);

        eventService.saveEvent(event);

        verify(eventRepository).save(event);
    }
}

