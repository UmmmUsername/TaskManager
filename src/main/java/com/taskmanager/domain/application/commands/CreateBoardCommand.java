package com.taskmanager.domain.application.commands;

import com.taskmanager.domain.model.team.TeamId;
import com.taskmanager.domain.model.user.UserId;

public class CreateBoardCommand {

    private UserId userId;
    private String name;
    private String description;
    private TeamId teamId;

    public CreateBoardCommand(UserId userId, String name, String description, TeamId teamId) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.teamId = teamId;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TeamId getTeamId() {
        return teamId;
    }
}
