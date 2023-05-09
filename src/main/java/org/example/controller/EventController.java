package org.example.controller;

import org.example.dto.EventDto;
import org.example.dto.EventDtoBuilder;
import org.example.entity.Event;
import org.example.service.EventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "event")
public class EventController {

    private final EventService eventService;

    private final EventDtoBuilder eventDtoBuilder;

    public EventController(EventService eventService, EventDtoBuilder eventDtoBuilder) {
        this.eventService = eventService;
        this.eventDtoBuilder = eventDtoBuilder;
    }

    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable(name = "id") Long id){

        Event event = eventService.findEvent(id);

        return eventDtoBuilder.fromEvent(event);
    }

    @PutMapping
    public void saveEvent(@RequestBody EventDto eventDto){

        Event event = eventDtoBuilder.fromEventDto(eventDto);

        eventService.saveEvent(event);
    }
}
