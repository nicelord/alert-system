package org.example.port.out;

import org.example.model.AlertType;
import org.example.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers(AlertType type);
}
