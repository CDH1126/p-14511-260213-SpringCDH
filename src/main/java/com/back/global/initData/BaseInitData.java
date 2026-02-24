package com.back.global.initData;

import com.back.domain.member.service.MemberService;
import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)
/// (readOnly = true) - 읽기 전용으로 설정
/// 장점: 내부적으로 성능 최적화를 거침, 함수의 의도를 명시적으로 표현 가능
///  클래스에 적용할 경우 명시하지 않아도 기본값으로 설정됨
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;
    private final MemberService memberService;

    @Bean
    ApplicationRunner devInitData() {
        // Bean 객체로 등록 시 스프링에서 파스칼표기법을 소문자로 변경하기 때문에 아예 다른 이름 사용
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            self.work2();
            self.work1();

        };
    }

    @Transactional
    void work1() {

        if (postService.count() > 0) {
            return;
        }


        postService.write(3,"제목1", "내용1");
        postService.write(4,"제목2", "내용2");
    }

    @Transactional
    void work2() {
        memberService.join("systemUser", "1234", "시스템");
        memberService.join("adminUser", "1234", "관리자");
        memberService.join("user1", "1234", "유저1");
        memberService.join("user2", "1234", "유저2");
        memberService.join("user3", "1234", "유저3");
    }



}
