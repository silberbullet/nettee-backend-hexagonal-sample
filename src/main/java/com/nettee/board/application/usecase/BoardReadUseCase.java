package com.nettee.board.application.usecase;

import com.nettee.board.application.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 게시판 조회 서비스 인터페이스 ( InPort 영역 )
 */
public interface BoardReadUseCase {

    /**
     * 게시판 목록 조회
     */
    Page<Board> getBoardList(Pageable pageable);

    /**
     * 게시판 상세 조회
     */
    Board getBoard (Long id);
}
