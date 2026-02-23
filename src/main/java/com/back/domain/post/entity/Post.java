package com.back.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity // 테이블과 연동하려면 사용해야 되는 어노테이션
// @Entity 사용 시 생성자가 필수 (없을 경우 기본 생성자)
@NoArgsConstructor
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 엔티티의 기본키(Primary Key) 값을 자동으로 생성해 주는 JPA 어노테이션

    @Column(length = 100, nullable = false)
    private String title = "";

    // TEXT 타입 사용 시 직접 명시를 해야 함
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content = "";

    @CreatedDate // 데이터 생성 날짜 자동 생성
    private LocalDateTime createDate;
    @LastModifiedDate // 데이터 수정 시간 자동 반영
    private LocalDateTime modifyDate;

    public Post(String title, String content) {
        this.createDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();

        this.title = title;
        this.content = content;
    }



}
