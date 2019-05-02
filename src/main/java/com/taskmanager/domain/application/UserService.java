package com.taskmanager.domain.application;

import com.taskmanager.domain.application.commands.RegistrationCommand;
import com.taskmanager.domain.model.user.RegistrationException;

public interface UserService {
    void register(RegistrationCommand command) throws RegistrationException;
}
