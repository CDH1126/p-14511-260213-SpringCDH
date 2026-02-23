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
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            new Thread(() -> {
                self.work1();
            }).start();

            self.work2();
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
}
