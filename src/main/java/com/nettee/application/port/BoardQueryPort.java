package com.nettee.application.port;

import com.nettee.application.domain.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardQueryPort {

    Page<Board> findAllBoard(Pageable pageable);

    Optional<Board> findBoardById(Long id);

}
