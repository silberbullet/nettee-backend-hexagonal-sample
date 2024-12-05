package com.nettee.adapter.out.persistence.board;

import com.nettee.application.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardJpaRepository extends JpaRepository<Board, Long> {
}
