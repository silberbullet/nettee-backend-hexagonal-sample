package com.nettee.board.adapter.out.persistence;

import com.nettee.board.adapter.out.persistence.entity.BoardEntity;
import com.nettee.board.adapter.out.mapper.BoardEntityMapper;
import com.nettee.board.application.domain.Board;
import com.nettee.board.application.port.BoardQueryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.nettee.board.adapter.out.persistence.entity.QBoardEntity.boardEntity;

/**
 * BoardQueryAdapter
 *
 * <p>
 * 게시판(Board) 도메인의 데이터를 JPA를 사용하여 관리하는 어댑터 클래스입니다.
 * {@link BoardQueryPort} 인터페이스를 구현하며, 게시판 목록 조회, 상세 조회 작업을 처리합니다.
 * </p>
 *
 * 주요 역할
 * - 게시판 목록 조회
 * - 게시판 상세 조회
 */
@Repository
public class BoardQueryAdapter extends QuerydslRepositorySupport implements BoardQueryPort {

    private final BoardEntityMapper boardEntityMapper;

    public BoardQueryAdapter(BoardEntityMapper boardEntityMapper) {
        super(BoardEntity.class);
        this.boardEntityMapper = boardEntityMapper;
    }

    @Override
    public Page<Board> findAllBoard(Pageable pageable) {
        // 삭제가 안된 게시판 조회
        var result = getQuerydsl().createQuery()
                .select(boardEntity)
                .from(boardEntity)
                .where(
                        boardEntity.deletedAt.isNull()
                ).fetch();

        var totalCount  = getQuerydsl().createQuery()
                .select(boardEntity.count())
                .from(boardEntity)
                .where(
                        boardEntity.deletedAt.isNull()
                );

        return PageableExecutionUtils.getPage(
                result.stream().map(boardEntityMapper::toDomain).toList(),
                pageable,
                totalCount::fetchOne);
    }

    @Override
    public Optional<Board> findBoardById(Long id) {
        return Optional.ofNullable(boardEntityMapper.toDomain(
                getQuerydsl().createQuery()
                .select(boardEntity)
                .from(boardEntity)
                .where(
                    boardEntity.deletedAt.isNull(),
                    boardEntity.id.eq(id)
                )
                .fetchOne()
                )
        );
    }
}
