package com.nettee.application.port.in;

import com.nettee.application.domain.board.Board;
import com.nettee.application.command.board.dto.BoardCreateCommand;
import com.nettee.application.command.board.dto.BoardDeleteCommand;
import com.nettee.application.command.board.dto.BoardUpdateCommand;

/**
 * 게시판 명령 서비스 인터페이스 ( InPort 영역 )
 */
public interface BoardCommandInPort {

    Board handle (BoardCreateCommand command);

    Board handle (BoardUpdateCommand command);

    void handle (BoardDeleteCommand command);
}
