package com.back.global;

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
    ApplicationRunner initDataRunner() {
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            self.work1();
            self.work2();
        };
    }

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
}
