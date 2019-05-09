package com.taskmanager.web.payload;

import com.taskmanager.domain.application.commands.AddCardCommand;
import com.taskmanager.domain.model.board.BoardId;
import com.taskmanager.domain.model.cardlist.CardListId;
import com.taskmanager.domain.model.user.UserId;

public class AddCardPayload {

    private long boardId;
    private long cardListId;
    private String title;
    private int position;

    public AddCardCommand toCommand(UserId userId) {
        return new AddCardCommand(new CardListId(cardListId), userId, title, position);
    }

    public BoardId getBoardId() {
        return new BoardId(boardId);
    }

    public void setBoardId(long boardId) {
        this.boardId = boardId;
    }

    public void setCardListId(long cardListId) {
        this.cardListId = cardListId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
