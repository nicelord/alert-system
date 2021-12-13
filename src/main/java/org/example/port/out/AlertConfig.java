package org.example.port.out;

public interface AlertConfig {

    int frequency();
    int duration();
    int waitTime();
    String tag();
}
