package com.taskmanager.web.apis;

import com.taskmanager.domain.application.BoardService;
import com.taskmanager.domain.common.security.CurrentUser;
import com.taskmanager.domain.model.board.Board;
import com.taskmanager.domain.model.user.SimpleUser;
import com.taskmanager.web.payload.CreateBoardPayload;
import com.taskmanager.web.results.ApiResult;
import com.taskmanager.web.results.CreateBoardResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BoardApiController {

    private BoardService boardService;

    public BoardApiController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/api/boards")
    public ResponseEntity<ApiResult> createBoard(@RequestBody CreateBoardPayload payload,
                                                 @CurrentUser SimpleUser currentUser) {
        Board board = boardService.createBoard(payload.toCommand(currentUser.getUserId()));
        return CreateBoardResult.build(board);
    }
}
