package org.example.dto;

import org.example.entity.Event;

public interface EventDtoBuilder {

    EventDto fromEvent(Event event);

    Event fromEventDto(EventDto eventDto);
}
