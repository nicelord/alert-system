package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class User {
    private final String name;
    private final NotificationPreferences pref;
    private final String email;
    private final String phone;
}
