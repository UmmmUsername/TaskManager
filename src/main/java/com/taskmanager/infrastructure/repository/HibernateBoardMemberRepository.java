package com.taskmanager.infrastructure.repository;

import com.taskmanager.domain.model.board.BoardMember;
import com.taskmanager.domain.model.board.BoardMemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class HibernateBoardMemberRepository extends HibernateSupport<BoardMember> implements BoardMemberRepository {

    HibernateBoardMemberRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
