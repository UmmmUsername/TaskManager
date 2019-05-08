package com.taskmanager.web.payload;

import com.taskmanager.domain.application.commands.CreateTeamCommand;
import com.taskmanager.domain.model.user.UserId;

public class CreateTeamPayload {

    private String name;

    public CreateTeamCommand toCommand(UserId userId) {
        return new CreateTeamCommand(userId, name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
