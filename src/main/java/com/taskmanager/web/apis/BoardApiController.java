package com.taskmanager.web.apis;

import com.taskmanager.domain.application.*;
import com.taskmanager.domain.common.security.CurrentUser;
import com.taskmanager.domain.model.board.Board;
import com.taskmanager.domain.model.board.BoardId;
import com.taskmanager.domain.model.card.Card;
import com.taskmanager.domain.model.cardlist.CardList;
import com.taskmanager.domain.model.team.Team;
import com.taskmanager.domain.model.user.SimpleUser;
import com.taskmanager.domain.model.user.User;
import com.taskmanager.domain.model.user.UserNotFoundException;
import com.taskmanager.web.payload.AddBoardMemberPayload;
import com.taskmanager.web.payload.CreateBoardPayload;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.BoardResult;
import com.taskmanager.web.results.CreateBoardResult;
import com.taskmanager.web.results.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BoardApiController {

    private BoardService boardService;
    private TeamService teamService;
    private CardListService cardListService;
    private CardService cardService;
    private UserService userService;

    public BoardApiController(BoardService boardService,
                              TeamService teamService,
                              CardListService cardListService,
                              CardService cardService) {
        this.boardService = boardService;
        this.teamService = teamService;
        this.cardListService = cardListService;
        this.cardService = cardService;
    }

    @PostMapping("/api/boards")
    public ResponseEntity<ApiResult> createBoard(@RequestBody CreateBoardPayload payload,
                                                 @CurrentUser SimpleUser currentUser) {
        Board board = boardService.createBoard(payload.toCommand(currentUser.getUserId()));
        return CreateBoardResult.build(board);
    }

    @GetMapping("/api/boards/{boardId}")
    public ResponseEntity<ApiResult> getBoard(@PathVariable("boardId") long rawBoardId) {
        BoardId boardId = new BoardId(rawBoardId);
        Board board = boardService.findById(boardId);
        if (board == null) {
            return Result.notFound();
        }
        List<User> members = boardService.findMembers(boardId);

        Team team = null;
        if (!board.isPersonal()) {
            team = teamService.findById(board.getTeamId());
        }

        List<CardList> cardLists = cardListService.findByBoardId(boardId);
        List<Card> cards = cardService.findByBoardId(boardId);

        return BoardResult.build(team, board, members, cardLists, cards);
    }

    @PostMapping("/api/boards/{boardId}/members")
    public ResponseEntity<ApiResult> addMember(@PathVariable("boardId") long rawBoardId,
                                               @RequestBody AddBoardMemberPayload payload) {
        BoardId boardId = new BoardId(rawBoardId);
        Board board = boardService.findById(boardId);
        if (board == null) {
            return Result.notFound();
        }

        try {
            User member = boardService.addMember(boardId, payload.getUsernameOrEmailAddress());

            ApiResult apiResult = ApiResult.blank()
                    .add("id", member.getId().value())
                    .add("shortName", member.getInitials());
            return Result.ok(apiResult);
        } catch (UserNotFoundException e) {
            return Result.failure("No user found");
        }
    }
}
