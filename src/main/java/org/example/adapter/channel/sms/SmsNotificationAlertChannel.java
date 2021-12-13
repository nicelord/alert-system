package org.example.adapter.channel.sms;

import org.example.model.AlertType;
import org.example.model.Notification;
import org.example.model.User;
import org.example.port.out.AlertChannel;
import org.example.port.out.ChannelConfig;

import java.util.List;

public class SmsNotificationAlertChannel implements AlertChannel {

    private final List<AlertType> alertTypeList;

    public SmsNotificationAlertChannel(List<AlertType> alertTypeList) {
        this.alertTypeList = alertTypeList;
    }


    @Override
    public void send(Notification notification, User user) {
        System.out.println("sending sms " + notification.getType() + " notification to " + user.getEmail());
    }

    @Override
    public ChannelConfig channelConfig() {
        return new SmsChannelConfig(alertTypeList);
    }
}
