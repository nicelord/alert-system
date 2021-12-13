package org.example.adapter.alert.blocker;

import org.example.port.out.AlertConfig;

public class BlockerAlertConfig implements AlertConfig {

    public static final int FREQUENCY = 5;
    public static final int DURATION = 100;
    public static final int WAIT_TIME = 100;
    public static final String TAG = "Blocker";

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
