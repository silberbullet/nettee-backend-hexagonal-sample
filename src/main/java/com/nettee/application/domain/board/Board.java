package com.nettee.application.domain.board;

import com.nettee.application.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

/**
 * 게시판 엔터티
 *
 * 주요 어노테이션 설명:
 * - @NoArgsConstructor(access = AccessLevel.PROTECTED)
 *   - JPA에서 기본 생성자가 필요하기에 NoArgsConstructor 사용
 *   - protected 접근을 지정하는 이유는 외부에서 직접 생성을 방지함. [ex. 타 비즈니스 로직에서 Board board = new Board (x) ], ( 일관성과 무결성을 유지하기 위함 )
 *   + 엔터티는 DB 테이블과 매핑되고 비즈니스 로직에 따라 일관된 상태를 방지하기 위함
 *
 * - @DynamicUpdate: 변경된 필드만 업데이트 쿼리에 포함시켜 성능 최적화를 제공
 * - @Entity(name = "board"): 이 클래스가 JPA 엔터티임을 나타내며, 데이터베이스 테이블 이름을 "board"로 매핑
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
@Entity(name = "board")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 20, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", columnDefinition = "LONGTEXT", nullable = false)
    private String content;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    /**
     * NoArgsConstructor 어노테이션과 같은 레벨 (클래스, 메소드..) 에서 쓰게 되면 에러!
     */
    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
        this.deletedAt = null;
    }

    // 제목 수정
    public void updateTitle(String title) {
        this.title = title;
    }

    // 내용 수정
    public void updateContent(String content) {
        this.content = content;
    }

    // 삭제
    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }
}
