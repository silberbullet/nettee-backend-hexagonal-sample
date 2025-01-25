package com.nettee.board.application.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

/**
 *  Board 도메인
 *  애플리케이션이 라이브러리를 의존하지 않기 위해 도메인과 도메인 엔터티로 나눕니다.
 */
@Getter
@Setter
@NoArgsConstructor
public class Board  {

    private Long id;

    private String title;

    private String content;

    private Instant deletedAt;

    @Builder
    public Board (Long id, String title, String content) {
       this.id = id;
       this.title = title;
       this.content = content;
       this.deletedAt = null;
    }
}
