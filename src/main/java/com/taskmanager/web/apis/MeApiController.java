package com.taskmanager.web.apis;

import com.taskmanager.domain.application.BoardService;
import com.taskmanager.domain.application.TeamService;
import com.taskmanager.domain.application.UserService;
import com.taskmanager.domain.common.security.CurrentUser;
import com.taskmanager.domain.model.board.Board;
import com.taskmanager.domain.model.team.Team;
import com.taskmanager.domain.model.user.SimpleUser;
import com.taskmanager.domain.model.user.User;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.MyDataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MeApiController {

    private TeamService teamService;
    private BoardService boardService;
    private UserService userService;

    public MeApiController(TeamService teamService, BoardService boardService, UserService userService) {
        this.teamService = teamService;
        this.boardService = boardService;
        this.userService = userService;
    }

    @GetMapping("/api/me")
    public ResponseEntity<ApiResult> getMyData(@CurrentUser SimpleUser currentUser) {
        User user = userService.findById(currentUser.getUserId());
        List<Team> teams = teamService.findTeamsByUserId(currentUser.getUserId());
        List<Board> boards = boardService.findBoardsByMembership(currentUser.getUserId());
        return MyDataResult.build(user, teams, boards);
    }
}
