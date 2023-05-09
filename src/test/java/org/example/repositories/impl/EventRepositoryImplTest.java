package org.example.repositories.impl;

import org.example.entity.Event;
import org.example.repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryImplTest {

    private final Long ID = 1L;
    private EventRepository repository;

    @BeforeEach
    void setup(){
        repository = new EventRepositoryImpl();
    }

    @Test
    void findById_ShouldFindEvent_WhenEventExists() {

        Event event = mock(Event.class);
        when(event.getId()).thenReturn(ID);

        repository.save(event);
        Event actualEvent = repository.findById(ID);

        assertEquals(actualEvent,event);
        assertNotNull(actualEvent);
    }

    @Test
    void save_ShouldSaveLastCalledEvent_WhenCalledMultipleTimes() {

        Event event = mock(Event.class);
        when(event.getId()).thenReturn(ID);
        Event lastEvent = mock(Event.class);
        when(lastEvent.getId()).thenReturn(ID);

        repository.save(event);
        repository.save(lastEvent);
        Event actualEvent = repository.findById(ID);

        assertNotNull(actualEvent);
        assertEquals(actualEvent, lastEvent);
    }
}