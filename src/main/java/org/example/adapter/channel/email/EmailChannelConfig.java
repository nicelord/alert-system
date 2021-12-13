package org.example.adapter.channel.email;

import org.example.model.AlertType;
import org.example.port.out.ChannelConfig;

import java.util.List;

public class EmailChannelConfig implements ChannelConfig {

    private final List<AlertType> alertTypeList;

    public EmailChannelConfig(List<AlertType> alertTypeList) {
        this.alertTypeList = alertTypeList;
    }

    @Override
    public List<AlertType> types() {
        return alertTypeList;
    }
}
