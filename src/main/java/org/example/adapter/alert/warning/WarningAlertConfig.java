package org.example.adapter.alert.warning;

import org.example.port.out.AlertConfig;

public class WarningAlertConfig implements AlertConfig {

    public static final int FREQUENCY = 10;
    public static final int DURATION = 100;
    public static final int WAIT_TIME = 100;
    public static final String TAG = "warning";

    @Override
    public int frequency() {
        return FREQUENCY;
    }

    @Override
    public int duration() {
        return DURATION;
    }

    @Override
    public int waitTime() {
        return WAIT_TIME;
    }

    @Override
    public String tag() {
        return TAG;
    }
}
