package org.example.service;

import org.example.model.AlertType;
import org.example.model.Notification;
import org.example.port.in.SendAlertRequest;
import org.example.port.out.Alert;
import org.example.port.out.AlertChannel;
import org.example.port.out.UserRepository;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class AlertSystem implements SendAlertRequest {

    private final List<AlertChannel> channels;
    private final List<Alert> alerts;
    private final UserRepository userRepository;
    private final File logFile;

    public AlertSystem(List<AlertChannel> channels, List<Alert> alerts, UserRepository userRepository, File logFile) {
        this.channels = channels;
        this.alerts = alerts;
        this.userRepository = userRepository;
        this.logFile = logFile;
    }


    @Override
    public void checkAndSendAlert() {

        for (Alert alert : alerts) {
            try {
                List<Notification> notifications = Files.lines(Path.of(logFile.toURI()))
                        .filter(s -> s.contains(alert.config().tag()))
                        .map(s -> {
                            LocalDate date = LocalDate.parse(s.split(" ")[0]);
                            LocalTime time = LocalTime.parse(s.split(" ")[1]);
                            AlertType type = AlertType.valueOf(s.split(" ")[2].toUpperCase());
                            String content = s.split(" ")[3];
                            return new Notification(LocalDateTime.of(date, time), type, content);
                        }).collect(Collectors.toList());


                Thread t = new Thread(() -> {
                    NotificationManager notificationManager = new NotificationManager(alert.config(),
                            channels,
                            userRepository.getUsers(AlertType.valueOf(alert.config().tag().toUpperCase()))
                    );

                    for (Notification notification : notifications) {
                        notificationManager.process(notification);
                    }
                });

                t.start();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }

}
