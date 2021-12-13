package org.example.adapter.channel.sms;

import org.example.model.AlertType;
import org.example.port.out.ChannelConfig;

import java.util.List;

public class SmsChannelConfig implements ChannelConfig {
    private final List<AlertType> alertTypes;

    public SmsChannelConfig(List<AlertType> alertTypeList) {
        this.alertTypes = alertTypeList;
    }

    @Override
    public List<AlertType> types() {
        return alertTypes;
    }
}
