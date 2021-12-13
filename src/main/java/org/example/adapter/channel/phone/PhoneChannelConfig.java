package org.example.adapter.channel.phone;

import org.example.model.AlertType;
import org.example.port.out.ChannelConfig;

import java.util.List;

public class PhoneChannelConfig implements ChannelConfig {

    private final List<AlertType> alertTypes;

    public PhoneChannelConfig(List<AlertType> alertTypes) {

        this.alertTypes = alertTypes;
    }

    @Override
    public List<AlertType> types() {
        return alertTypes;
    }
}
