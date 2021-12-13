package org.example;

import org.example.adapter.alert.blocker.BlockerAlert;
import org.example.adapter.alert.critical.CriticalAlert;
import org.example.adapter.alert.info.InfoAlert;
import org.example.adapter.alert.warning.WarningAlert;
import org.example.adapter.channel.email.EmailNotificationAlertChannel;
import org.example.adapter.channel.phone.PhoneNotificationAlertChannel;
import org.example.adapter.channel.sms.SmsNotificationAlertChannel;
import org.example.adapter.persistence.InMemUserRepository;
import org.example.config.AppConfig;
import org.example.port.in.SendAlertRequest;
import org.example.port.out.Alert;
import org.example.port.out.AlertChannel;
import org.example.port.out.UserRepository;
import org.example.service.AlertSystem;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        File logFile = null;

        if (0 < args.length) {
            logFile = new File(args[0]);
        } else {
            logFile = new File(Paths.get(AppConfig.getFilePath()).toUri());
        }

        AlertChannel emailChannel = new EmailNotificationAlertChannel(AppConfig.getEmailChannelType());
        AlertChannel phoneChannel = new PhoneNotificationAlertChannel(AppConfig.getPhoneChannelType());
        AlertChannel smsChannel = new SmsNotificationAlertChannel(AppConfig.getSmsChannelType());

        Alert info = new InfoAlert();
        Alert warning = new WarningAlert();
        Alert critical = new CriticalAlert();
        Alert blocker = new BlockerAlert();
        UserRepository userRepo = new InMemUserRepository();


        SendAlertRequest sendAlertRequest = new AlertSystem(
                Arrays.asList(emailChannel, phoneChannel, smsChannel),
                Arrays.asList(info, warning, critical, blocker), userRepo,
                logFile);

        sendAlertRequest.checkAndSendAlert();


    }
}
