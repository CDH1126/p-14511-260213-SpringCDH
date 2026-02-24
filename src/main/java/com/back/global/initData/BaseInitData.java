package com.back.global.initData;

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

    @Bean
    ApplicationRunner devInitData() {
        // Bean 객체로 등록 시 스프링에서 파스칼표기법을 소문자로 변경하기 때문에 아예 다른 이름 사용
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            self.work1();
            self.work2();
            self.work3();
        };
    }

    @Transactional
    void work1() {

        if (postService.count() > 0) {
            return;
        }

        // 테스트 데이터가 2개인 것을 가정하고 개발
        postService.write("제목1", "내용1");

        /*
            if (true) {
                throw new RuntimeException("테스트 예외");
            }
         */
        postService.write("제목2", "내용2");
    }


    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }

    @Transactional // 기본값이 readOnly 가 되었기 때문에 Transactional 지정
    void work3() {
        Post post = postService.findById(1).get();
        postService.modify(post, "제목1-1", "내용1-1");
    }

}
