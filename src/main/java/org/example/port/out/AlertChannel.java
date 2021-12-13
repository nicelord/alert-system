package org.example.port.out;

import org.example.model.Notification;
import org.example.model.User;

public interface AlertChannel {
    void send(Notification notification, User user);
    ChannelConfig channelConfig();
}
