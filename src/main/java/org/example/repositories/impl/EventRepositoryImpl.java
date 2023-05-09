package org.example.repositories.impl;

import org.example.entity.Event;
import org.example.repositories.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class EventRepositoryImpl implements EventRepository {

    private final HashMap<Long, Event> storage;

    public EventRepositoryImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public Event findById(Long id) {
        return storage.get(id);
    }

    @Override
    public Event save(Event event) {
        return storage.put(event.getId(), event);
    }
}
