package com.nettee.board.adapter.out.mapper;

import com.nettee.board.adapter.out.persistence.entity.BoardEntity;
import com.nettee.board.application.domain.Board;
import org.mapstruct.Mapper;

/**
 *  BoardMapper
 *
 *  Domain <-> Entity 간에 매핑을 위한 인터페이스
 */
@Mapper(componentModel = "spring")
public interface BoardEntityMapper {

    Board toDomain(BoardEntity boardEntity);

    BoardEntity toEntity(Board board);
}
