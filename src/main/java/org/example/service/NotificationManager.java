package org.example.service;

import org.example.model.Notification;
import org.example.model.User;
import org.example.port.out.AlertChannel;
import org.example.port.out.AlertConfig;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


class NotificationManager {

    private final List<Notification> queue = new ArrayList<>();

    private final int duration;
    private final int frequency;
    private final int waitTime;
    private final List<User> users;
    private final List<AlertChannel> channels;

    private LocalDateTime checkPoint;


    public NotificationManager(AlertConfig config, List<AlertChannel> channels,
                               List<User> users) {
        this.duration = config.duration();
        this.frequency = config.frequency();
        this.waitTime = config.waitTime();
        this.users = users;
        this.channels = channels;
    }


    public void process(Notification notification) {
        append(notification);
    }

    private void append(Notification notification) {

        if (checkPoint == null) {
            resetAt(notification.getOccurredOn());
        } else {
            if (Duration.between(checkPoint, notification.getOccurredOn()).toSeconds() >= duration) {
                resetAt(notification.getOccurredOn());
            }
        }

        queue.add(notification);

        if (queue.size() == frequency) {
            send();
        }

    }

    private void resetAt(LocalDateTime occurredOn) {
        checkPoint = occurredOn;
        queue.clear();

    }

    private void send() {
        System.out.println("--");
        for (Notification notification : queue) {
            for (User user : users) {
                for (AlertChannel channel : channels) {
                    if(channel.channelConfig().types().contains(notification.getType())){
                        channel.send(notification, user);
                    }
                }
            }
        }

        try {
            Thread.sleep(waitTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
