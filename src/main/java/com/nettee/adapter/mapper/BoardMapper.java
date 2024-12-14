package com.nettee.adapter.mapper;

import com.nettee.adapter.in.web.board.dto.BoardCreateCommand;
import com.nettee.adapter.in.web.board.dto.BoardDeleteCommand;
import com.nettee.adapter.in.web.board.dto.BoardDto;
import com.nettee.adapter.in.web.board.dto.BoardUpdateCommand;
import com.nettee.application.domain.board.Board;
import org.mapstruct.Mapper;

/**
 *  BoardMapper
 *
 *  DTO <-> Entity 간에 매핑을 위한 인터페이스
 */
@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto toDto(Board board);

    Board toEntity(BoardCreateCommand command);

    Board toEntity(BoardUpdateCommand command);

}
