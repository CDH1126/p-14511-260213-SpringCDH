package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// 인터페이스 ==> 모든 메서드가 추상메서드인 추상 클래스
public interface PostRepository extends JpaRepository<Post, Integer> { }
