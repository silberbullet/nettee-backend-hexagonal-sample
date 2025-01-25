package com.nettee.board.adapter.out.persistence;

import com.nettee.board.adapter.out.persistence.mapper.BoardEntityMapper;
import com.nettee.board.application.domain.Board;
import com.nettee.board.application.port.BoardCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * BoardCommandAdapter
 *
 * <p>
 * 게시판(Board) 도메인의 데이터를 JPA를 사용하여 관리하는 어댑터 클래스입니다.
 * {@link BoardCommandPort} 인터페이스를 구현하며, 게시판 생성, 수정, 삭제 등의
 * 명령(Command) 작업을 처리합니다.
 * </p>
 *
 * 주요 역할
 * - 새로운 게시판 생성
 * - 기존 게시판 수정
 * - 게시판 삭제
 */
@Repository
@RequiredArgsConstructor
public class BoardCommandAdapter implements BoardCommandPort {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardEntityMapper boardEntityMapper;

    @Override
    public Board createBoard(Board board) {
        var boardEntity = boardEntityMapper.toEntity(board);

        return boardEntityMapper.toDomain(boardJpaRepository.save(boardEntity));
    }

    @Override
    public Board updateBoard(Board board) {
        var existBoard = boardJpaRepository.findById(board.getId()).orElseThrow(
                () -> new IllegalArgumentException("Board not found")
        );

        existBoard.prepareUpdate()
                .title(board.getTitle())
                .content(board.getContent())
                .update();

        return boardEntityMapper.toDomain(
                boardJpaRepository.save(existBoard));
    }

    @Override
    public void deleteBoard(Long id) {
        var existBoard = boardJpaRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Board not found")
        );

        existBoard.softDelete();
    }
}
