package com.nettee.application.mapper;

import com.nettee.adapter.in.web.board.dto.BoardDto;
import com.nettee.application.domain.board.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardDto toDto(Board board);
}
