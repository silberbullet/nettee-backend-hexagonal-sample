package com.nettee.board.application.port;

import com.nettee.board.application.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardQueryPort {

    Page<Board> findAllBoard(Pageable pageable);

    Optional<Board> findBoardById(Long id);
}
