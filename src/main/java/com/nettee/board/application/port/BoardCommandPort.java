package com.nettee.board.application.port;

import com.nettee.board.application.domain.Board;

public interface BoardCommandPort {

    Board createBoard(Board board);

    Board updateBoard(Board board);

    void deleteBoard(Long id);
}
