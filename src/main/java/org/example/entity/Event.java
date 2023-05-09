package org.example.entity;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private Long id;

    private String name;

    private LocalDateTime startEvent = LocalDateTime.now();

    private LocalDateTime endEvent = LocalDateTime.now();
}
