package org.example.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
public class Notification {
    private final LocalDateTime occurredOn;
    private final AlertType type;
    private final String data;

}
