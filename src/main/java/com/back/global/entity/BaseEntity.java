package com.back.global.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 공통 필드를 여러 엔티티에서 상속받아 사용하기 위한 상속용 어노테이션
@Getter
@EntityListeners(AuditingEntityListener.class)
abstract public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 엔티티의 기본키(Primary Key) 값을 자동으로 생성해 주는 JPA 어노테이션

    @CreatedDate // 데이터 생성 날짜 자동 생성
    private LocalDateTime createDate;

    @LastModifiedDate // 데이터 수정 시간 자동 반영
    private LocalDateTime modifyDate;

}
