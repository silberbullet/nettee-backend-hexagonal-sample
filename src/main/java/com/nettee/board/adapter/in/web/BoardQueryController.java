package com.nettee.board.adapter.in.web;

import com.nettee.board.adapter.in.web.dto.BoardDto;
import com.nettee.board.adapter.in.web.mapper.BoardDtoMapper;
import com.nettee.board.application.usecase.BoardReadUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "board-query-controller")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardQueryController {

    private final BoardReadUseCase boardReadUseCase;
    private final BoardDtoMapper boardDtoMapper;

    @Operation(
            summary = "게시판 목록 조회 API",
            description = """
                    <p>
                        삭제되지 않은 게시판 목록 조회
                    </p>
                    """
    )
    @GetMapping
    public ResponseEntity<Page<BoardDto>> getBoardList(Pageable pageable) {

        var boardList = boardReadUseCase.getBoardList(pageable).stream()
                        .map(boardDtoMapper::toDto)
                        .toList();

        return ResponseEntity.ok(new PageImpl<>(boardList, pageable, boardList.size()));
    }

    @Operation(
            summary = "게시판 상세 조회 API",
            description = """
                    <p>
                        id로 게시판 상세 조회
                   </p>
                   """
    )
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable Long boardId){
        var board = boardReadUseCase.getBoard(boardId);

        return ResponseEntity.ok(boardDtoMapper.toDto(board));
    }
}
