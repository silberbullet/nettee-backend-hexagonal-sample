package com.nettee.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * 공통 엔터티 클래스
 * 모든 엔터티에 대해 생성 시간(createdAt)과 수정 시간(updatedAt)을 자동으로 관리
 *
 * 주요 어노테이션 설명:
 * - @MappedSuperclass: 이 클래스가 엔티티가 아닌 공통 매핑 정보를 제공하는 슈퍼클래스임
 * - @EntityListeners(AuditingEntityListener.class): JPA 엔티티 리스너를 등록하여 생성 및 수정 시간을 자동으로 설정
 * - @CreatedDate: 엔티티가 처음 생성될 때의 시간을 자동으로 설정
 * - @LastModifiedDate: 엔티티가 마지막으로 수정될 때의 시간을 자동으로 설정
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    /**
     * 엔터티 생성 시간
     */
    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    /**
     * 엔터티 수정 시간
     */
    @LastModifiedDate
    @Column(name ="updated_at")
    private Instant updatedAt;
}
