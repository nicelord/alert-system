package org.example.port.out;

import org.example.model.AlertType;

import java.util.List;

public interface ChannelConfig {
    List<AlertType> types();
}
