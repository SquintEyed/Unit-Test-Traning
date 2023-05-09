package org.example.dto.impl;

import org.example.dto.EventDto;
import org.example.dto.EventDtoBuilder;
import org.example.entity.Event;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class EventDtoBuilderImpl implements EventDtoBuilder {


    @Override
    public EventDto fromEvent(Event event) {
        return new EventDto(event.getName(),
                event.getId(),
                event.getStartEvent(),
                event.getEndEvent());
    }

    @Override
    public Event fromEventDto(EventDto eventDto) {
        return new Event(eventDto.getId(),
                eventDto.getName(),
                eventDto.getStartEvent(),
                eventDto.getEndEvent());
    }
}
