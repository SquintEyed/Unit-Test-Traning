package org.example.service;


import org.example.entity.Event;

public interface EventService {

    Event findEvent(Long id);

    Event saveEvent(Event event);
}
