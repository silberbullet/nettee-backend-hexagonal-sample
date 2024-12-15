package com.nettee.board.adapter.out.persistence;

import com.nettee.board.adapter.out.persistence.entity.BoardEntity;
import com.nettee.board.application.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardJpaRepository extends JpaRepository<BoardEntity, Long> {
}
