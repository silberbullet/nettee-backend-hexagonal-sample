package com.nettee.board.application.service;

import com.nettee.board.application.domain.Board;
import com.nettee.board.application.port.BoardCommandPort;
import com.nettee.board.application.usecase.BoardCreateUseCase;
import com.nettee.board.application.usecase.BoardDeleteUseCase;
import com.nettee.board.application.usecase.BoardUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardCommandService implements BoardCreateUseCase, BoardUpdateUseCase, BoardDeleteUseCase {

    private final BoardCommandPort boardCommandPort;

    @Override
    @Transactional
    public Board createBoard(Board board) {

        return boardCommandPort.createBoard(board);
    }

    @Override
    @Transactional
    public Board updateBoard(Board board) {

        return boardCommandPort.updateBoard(board);
    }

    @Override
    @Transactional
    public void deleteBoard(Long boardId) {

        boardCommandPort.deleteBoard(boardId);
    }

}
