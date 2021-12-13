package org.example.adapter.alert.blocker;

import org.example.port.out.Alert;
import org.example.port.out.AlertConfig;

public class BlockerAlert implements Alert {

    @Override
    public AlertConfig config() {
        return new BlockerAlertConfig();
    }

}
