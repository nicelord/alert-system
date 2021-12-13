package org.example.adapter.alert.info;

import org.example.port.out.AlertConfig;
import org.example.port.out.Alert;

public class InfoAlert implements Alert {

    @Override
    public AlertConfig config() {
        return new InfoAlertConfig();
    }

}
