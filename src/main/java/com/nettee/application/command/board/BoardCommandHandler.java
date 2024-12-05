package com.nettee.application.command.board;

import com.nettee.adapter.out.persistence.board.BoardJpaRepository;
import com.nettee.application.command.board.dto.BoardCreateCommand;
import com.nettee.application.command.board.dto.BoardDeleteCommand;
import com.nettee.application.command.board.dto.BoardUpdateCommand;
import com.nettee.application.domain.board.Board;
import com.nettee.application.port.in.BoardCommandInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class BoardCommandHandler implements BoardCommandInPort {

    private final BoardJpaRepository boardJpaRepository;

    @Override
    @Transactional
    public Board handle(BoardCreateCommand command) {
        var board = Board.builder()
                .title(command.title())
                .content(command.content())
                .build();

        return  boardJpaRepository.save(board);
    }

    @Override
    @Transactional
    public Board handle(BoardUpdateCommand command) {
        var board = boardJpaRepository.findById(command.id()).orElseThrow(
                ()-> new IllegalArgumentException("Board not found")
        );

        board.updateTitle(command.title());
        board.updateContent(command.content());

        return board;
    }

    @Override
    @Transactional
    public void handle(BoardDeleteCommand command) {
        var board = boardJpaRepository.findById(command.id()).orElseThrow(
                ()-> new IllegalArgumentException("Board not found")
        );

        board.softDelete();
    }
}
