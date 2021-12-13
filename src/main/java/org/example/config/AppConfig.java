package org.example.config;

import org.example.model.AlertType;
import org.example.model.NotificationPreferences;
import org.example.model.User;

import java.util.Arrays;
import java.util.List;

public class AppConfig {

    private static final String FILE_PATH = "log.txt";
    private static final List<AlertType> EMAIL_ALERT_TYPE_LIST = Arrays.asList(AlertType.INFO);
    private static final List<AlertType> SMS_ALERT_TYPE_LIST = Arrays.asList(AlertType.INFO, AlertType.CRITICAL);
    private static final List<AlertType> PHONE_ALERT_TYPE_LIST = Arrays.asList(AlertType.CRITICAL);

    private static final List<User> USERS = Arrays.asList(
            new User("a", new NotificationPreferences(Arrays.asList(AlertType.CRITICAL, AlertType.BLOCKER)), "a@a", "phone-a"),
            new User("b", new NotificationPreferences(Arrays.asList(AlertType.CRITICAL, AlertType.WARNING)), "b@b", "phone-b"),
            new User("c", new NotificationPreferences(Arrays.asList(AlertType.CRITICAL, AlertType.INFO)), "c@c", "phone-c"),
            new User("d", new NotificationPreferences(Arrays.asList(AlertType.INFO, AlertType.BLOCKER)), "d@d", "phone-d"),
            new User("e", new NotificationPreferences(Arrays.asList(AlertType.BLOCKER, AlertType.WARNING)), "e@e", "phone-e")
    );

    public static List<User> getUsers() {
        return USERS;
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static List<AlertType> getEmailChannelType() {
        return EMAIL_ALERT_TYPE_LIST;
    }

    public static List<AlertType> getSmsChannelType() {
        return SMS_ALERT_TYPE_LIST;
    }

    public static List<AlertType> getPhoneChannelType() {
        return PHONE_ALERT_TYPE_LIST;
    }
}
