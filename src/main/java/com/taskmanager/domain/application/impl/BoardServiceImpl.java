package com.taskmanager.domain.application.impl;

import com.taskmanager.domain.application.BoardService;
import com.taskmanager.domain.application.commands.CreateBoardCommand;
import com.taskmanager.domain.common.event.DomainEventPublisher;
import com.taskmanager.domain.model.board.*;
import com.taskmanager.domain.model.board.events.BoardCreatedEvent;
import com.taskmanager.domain.model.board.events.BoardMemberAddedEvent;
import com.taskmanager.domain.model.user.User;
import com.taskmanager.domain.model.user.UserFinder;
import com.taskmanager.domain.model.user.UserId;
import com.taskmanager.domain.model.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;
    private BoardManagement boardManagement;
    private BoardMemberRepository boardMemberRepository;
    private UserFinder userFinder;
    private DomainEventPublisher domainEventPublisher;

    public BoardServiceImpl(BoardRepository boardRepository,
                            BoardManagement boardManagement,
                            BoardMemberRepository boardMemberRepository,
                            UserFinder userFinder,
                            DomainEventPublisher domainEventPublisher) {
        this.boardRepository = boardRepository;
        this.boardManagement = boardManagement;
        this.boardMemberRepository = boardMemberRepository;
        this.userFinder = userFinder;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Override
    public List<Board> findBoardsByMembership(UserId userId) {
        return boardRepository.findBoardsByMembership(userId);
    }

    @Override
    public Board findById(BoardId boardId) {
        return boardRepository.findById(boardId);
    }

    @Override
    public List<User> findMembers(BoardId boardId) {
        return boardMemberRepository.findMembers(boardId);
    }

    @Override
    public Board createBoard(CreateBoardCommand command) {
        Board board = boardManagement.createBoard(command.getUserId(), command.getName(),
                command.getDescription(), command.getTeamId());
        domainEventPublisher.publish(new BoardCreatedEvent(this, board));
        return board;
    }

    @Override
    public User addMember(BoardId boardId, String usernameOrEmailAddress) throws UserNotFoundException {
        User user = userFinder.find(usernameOrEmailAddress);
        boardMemberRepository.add(boardId, user.getId());
        domainEventPublisher.publish(new BoardMemberAddedEvent(this, boardId, user));
        return user;
    }
}
