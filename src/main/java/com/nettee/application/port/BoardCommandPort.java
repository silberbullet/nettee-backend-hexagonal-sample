package com.nettee.application.port;

import com.nettee.application.domain.board.Board;

public interface BoardCommandPort {

    Board createBoard(Board board);

    Board updateBoard(Board board);

    void deleteBoard(Long id);
}
