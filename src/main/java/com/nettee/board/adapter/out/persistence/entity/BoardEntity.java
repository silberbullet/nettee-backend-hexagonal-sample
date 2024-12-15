package com.nettee.board.adapter.out.persistence.entity;

import com.nettee.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.Objects;

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
public class BoardEntity extends BaseTimeEntity {

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
    public BoardEntity(String title, String content) {
        this.title = title;
        this.content = content;
        this.deletedAt = null;
    }

    /**
     * JPA 수정 메소드 작성 시, 고려해야 하는 요점
     *
     * 1) 매개변수가 컬럼 단위 일 시 : 성능 측면에서는 이득, 유지보수 측면에서는 비효율적
     * -> ex) 수정해야하는 컬럼 추가가 됐을 때, 수정 코드들 전부 수정 필요
     *
     * 2) 매개변수가 도메인 단위 (객체 or Builder) 일 시 : 수정 시 객체 생성 비용이 생겨 성능은 양보, 유지보수 측면에서는 효율적
     * -> ex) 수정해야하는 컬럼이 있어도, 컴파일 에러 안남
     */
    @Builder(builderMethodName = "prepareUpdate", buildMethodName = "update")
    public void updateBoard(String title, String content) {
        // null 대입을 예방하는 방어 코드
        Objects.requireNonNull(title, "title cannot be null");
        Objects.requireNonNull(content, "content cannot be null");

        this.title = title;
        this.content = content;
    }
    // 삭제
    public void softDelete() {
        this.deletedAt = LocalDateTime.now();
    }
}
