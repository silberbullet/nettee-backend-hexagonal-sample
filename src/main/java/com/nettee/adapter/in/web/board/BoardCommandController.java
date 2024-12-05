package com.nettee.adapter.in.web.board;

import com.nettee.adapter.in.web.board.dto.BoardDto;
import com.nettee.application.mapper.BoardMapper;
import com.nettee.application.port.in.BoardCommandInPort;
import com.nettee.application.command.board.dto.BoardCreateCommand;
import com.nettee.application.command.board.dto.BoardDeleteCommand;
import com.nettee.application.command.board.dto.BoardUpdateCommand;
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

    private final BoardCommandInPort commandHandler;
    private final BoardMapper boardMapper;

    @Operation(
            summary = "게시판 등록 API",
            description = "등록할 게시판 데이터를 전달받아 새로운 게시판을 등록합니다."
    )
    @PostMapping
    public ResponseEntity<BoardDto> create(@RequestBody @Valid BoardCreateCommand command) {

        var board = commandHandler.handle(command);

        return ResponseEntity.ok(boardMapper.toDto(board));
    }

    @Operation(
            summary = "게시판 수정 API",
            description = "수정할 포스트의 항목(들)을 전달받아 포스트를 수정합니다."
    )
    @PatchMapping("/{boardId}")
    public ResponseEntity<BoardDto> update(@RequestBody BoardUpdateCommand command) {

        var board =  commandHandler.handle(command);

        return ResponseEntity.ok(boardMapper.toDto(board));
    }

    @Operation(
            summary = "게시판 삭제 API",
            description = "삭제할 게시판의 PK 값을 전달받아 게시판을 삭제합니다."
    )
    @DeleteMapping("/{boardId}")
    public void delete(@RequestBody BoardDeleteCommand command) {

        commandHandler.handle(command);
    }
}
