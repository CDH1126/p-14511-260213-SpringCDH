package com.back.domain.wiseSaying.entity;

import jakarta.persistence.*;

@Entity // 테이블과 연동하려면 사용해야 되는 어노테이션
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 엔티티의 기본키(Primary Key) 값을 자동으로 생성해 주는 JPA 어노테이션

    @Column(length = 100, nullable = false)
    private String title;

    // TEXT 타입 사용 시 직접 명시를 해야 함
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;



}
