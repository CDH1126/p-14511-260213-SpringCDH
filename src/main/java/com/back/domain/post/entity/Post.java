package com.back.domain.post.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity // 테이블과 연동하려면 사용해야 되는 어노테이션
// @Entity 사용 시 생성자가 필수 (없을 경우 기본 생성자)
@NoArgsConstructor
@Setter
@Getter
public class Post extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String title;

    // TEXT 타입 사용 시 직접 명시를 해야 함
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;



    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }



}
