package org.example.repositories;

import org.example.entity.Event;

public interface EventRepository  {

    Event findById(Long id);

    Event save(Event event);
}
