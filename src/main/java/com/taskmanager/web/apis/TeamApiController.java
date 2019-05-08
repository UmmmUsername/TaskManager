package com.taskmanager.web.apis;

import com.taskmanager.domain.application.TeamService;
import com.taskmanager.domain.common.security.CurrentUser;
import com.taskmanager.domain.model.team.Team;
import com.taskmanager.domain.model.user.SimpleUser;
import com.taskmanager.web.payload.CreateTeamPayload;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.CreateTeamResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TeamApiController {

    private TeamService teamService;

    public TeamApiController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/api/teams")
    public ResponseEntity<ApiResult> createTeam(@RequestBody CreateTeamPayload payload,
                                                @CurrentUser SimpleUser currentUser) {
        Team team = teamService.createTeam(payload.toCommand(currentUser.getUserId()));
        return CreateTeamResult.build(team);
    }
}
