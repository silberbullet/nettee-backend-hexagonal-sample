package com.nettee.board.adapter.in.web;

import com.nettee.board.adapter.in.mapper.BoardDtoMapper;
import com.nettee.board.adapter.in.web.dto.BoardDto;
import com.nettee.board.adapter.in.web.dto.BoardCreateCommand;
import com.nettee.board.adapter.in.web.dto.BoardDeleteCommand;
import com.nettee.board.adapter.in.web.dto.BoardUpdateCommand;
import com.nettee.board.adapter.out.persistence.entity.BoardEntity;
import com.nettee.board.adapter.out.persistence.mapper.BoardEntityMapper;
import com.nettee.board.application.usecase.BoardCreateUseCase;
import com.nettee.board.application.usecase.BoardDeleteUseCase;
import com.nettee.board.application.usecase.BoardUpdateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "board-command-controller")
@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardCommandController {

    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardUpdateUseCase boardUpdateUseCase;
    private final BoardDeleteUseCase boardDeleteUseCase;
    private final BoardDtoMapper boardDtoMapper;

    @Operation(
            summary = "게시판 등록 API",
            description = "등록할 게시판 데이터를 전달받아 새로운 게시판을 등록합니다."
    )
    @PostMapping
    public ResponseEntity<BoardDto> create(@RequestBody @Valid BoardCreateCommand command) {

        var board = boardCreateUseCase.createBoard(boardDtoMapper.toDomain(command));

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }

    @Operation(
            summary = "게시판 수정 API",
            description = "수정할 포스트의 항목(들)을 전달받아 포스트를 수정합니다."
    )
    @PatchMapping("/{boardId}")
    public ResponseEntity<BoardDto> update(@RequestBody BoardUpdateCommand command) {

        var board =  boardUpdateUseCase.updateBoard(boardDtoMapper.toDomain(command));

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }

    @Operation(
            summary = "게시판 삭제 API",
            description = "삭제할 게시판의 PK 값을 전달받아 게시판을 삭제합니다."
    )
    @DeleteMapping("/{boardId}")
    public void delete(@RequestBody BoardDeleteCommand command) {

        boardDeleteUseCase.deleteBoard(command.id());
    }
}
