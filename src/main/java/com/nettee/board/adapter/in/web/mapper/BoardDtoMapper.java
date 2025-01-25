package com.nettee.board.adapter.in.web.mapper;

import com.nettee.board.adapter.in.web.dto.BoardCreateCommand;
import com.nettee.board.adapter.in.web.dto.BoardDto;
import com.nettee.board.adapter.in.web.dto.BoardUpdateCommand;
import com.nettee.board.application.domain.Board;
import org.mapstruct.Mapper;

/**
 *  BoardDtoMapper
 *  DTO <-> Domain 간에 매핑을 위한 인터페이스
 */
@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    BoardDto toDto(Board board);

    Board toDomain(BoardCreateCommand command);

    Board toDomain(BoardUpdateCommand command);
}
