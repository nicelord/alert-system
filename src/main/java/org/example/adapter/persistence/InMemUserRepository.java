package org.example.adapter.persistence;

import org.example.config.AppConfig;
import org.example.model.AlertType;
import org.example.model.User;
import org.example.port.out.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class InMemUserRepository implements UserRepository {

    @Override
    public List<User> getUsers(AlertType type) {
        return AppConfig.getUsers().stream().filter(user -> user.getPref().getAlertType().contains(type)).collect(Collectors.toList());
    }
}
