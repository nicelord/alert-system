package org.example.adapter.alert.critical;

import org.example.port.out.AlertConfig;

public class CriticalAlertConfig implements AlertConfig {

    public static final int FREQUENCY = 5;
    public static final int DURATION = 5;
    public static final int WAIT_TIME = 1;
    public static final String TAG = "Critical";

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
