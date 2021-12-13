package org.example.adapter.alert.critical;

import org.example.port.out.Alert;
import org.example.port.out.AlertConfig;

public class CriticalAlert implements Alert {

    @Override
    public AlertConfig config() {
        return new CriticalAlertConfig();
    }

}
