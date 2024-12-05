package com.nettee.application.port.in;

import com.nettee.application.domain.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 게시판 조회 서비스 인터페이스 ( InPort 영역 )
 */
public interface BoardQueryInPort {

    /**
     * 게시판 목록 조회
     */
    Page<Board> getBoardList(Pageable pageable);

    /**
     * 게시판 상세 조회
     */
    Board getBoard (Long id);
}
