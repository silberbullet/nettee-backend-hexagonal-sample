package com.nettee.adapter.out.persistence.board;

import com.nettee.application.domain.board.Board;
import com.nettee.application.port.out.BoardQueryOutPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.nettee.application.domain.board.QBoard.board;

@Repository
public class BoardQueryAdapter extends QuerydslRepositorySupport implements BoardQueryOutPort {

    public BoardQueryAdapter() { super(Board.class); }

    @Override
    public Page<Board> findAllBoard(Pageable pageable) {

        var result = getQuerydsl().createQuery()
                .select(board)
                .from(board)
                .where(
                        board.deletedAt.isNull()
                ).fetch();

        var totalCount  = getQuerydsl().createQuery()
                .select(board.count())
                .from(board)
                .where(
                        board.deletedAt.isNull()
                );

        return PageableExecutionUtils.getPage(result, pageable, totalCount::fetchOne);
    }

    @Override
    public Optional<Board> findBoardById(Long id) {
        return Optional.ofNullable(getQuerydsl().createQuery()
                .select(board)
                .from(board)
                .where(
                    board.deletedAt.isNull(),
                    board.id.eq(id)
                )
                .fetchOne()
        );
    }
}
