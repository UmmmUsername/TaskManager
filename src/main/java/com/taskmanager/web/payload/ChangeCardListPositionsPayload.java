package com.taskmanager.web.payload;

import com.taskmanager.domain.application.commands.ChangeCardListPositionsCommand;
import com.taskmanager.domain.model.board.BoardId;
import com.taskmanager.domain.model.cardlist.CardListPosition;

import java.util.List;

public class ChangeCardListPositionsPayload {

    private long boardId;
    private List<CardListPosition> cardListPositions;

    public ChangeCardListPositionsCommand toCommand() {
        return new ChangeCardListPositionsCommand(new BoardId(boardId), cardListPositions);
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public void setCardListPositions(List<CardListPosition> cardListPositions) {
        this.cardListPositions = cardListPositions;
    }
}
