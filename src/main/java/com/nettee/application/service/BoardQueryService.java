package com.nettee.application.service;

import com.nettee.application.domain.board.Board;
import com.nettee.application.port.in.BoardQueryInPort;
import com.nettee.application.port.out.BoardQueryOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardQueryService implements BoardQueryInPort {

    private final BoardQueryOutPort outPort;

    @Override
    @Transactional(readOnly = true)
    public Page<Board> getBoardList(Pageable pageable)  {

        return outPort.findAllBoard(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Board getBoard(Long id){

        return outPort.findBoardById(id).orElseThrow(
                ()-> new IllegalArgumentException("Board not found")
        );
    }
}
