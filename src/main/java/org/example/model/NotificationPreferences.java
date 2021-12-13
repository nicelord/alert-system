package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class NotificationPreferences {
    private final List<AlertType> alertType;
}
