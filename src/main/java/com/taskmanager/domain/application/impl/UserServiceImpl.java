package com.taskmanager.domain.application.impl;

import com.taskmanager.domain.application.UserService;
import com.taskmanager.domain.application.commands.RegistrationCommand;
import com.taskmanager.domain.model.user.RegistrationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void register(RegistrationCommand command) throws RegistrationException {

    }
}
