package org.example.adapter.alert.warning;

import org.example.port.out.Alert;
import org.example.port.out.AlertConfig;

public class WarningAlert implements Alert {

    @Override
    public AlertConfig config() {
        return new WarningAlertConfig();
    }

}
