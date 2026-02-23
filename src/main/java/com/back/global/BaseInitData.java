package com.back.global;

import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            work1();
            work2();
        };
    }

    void work1() {
        try {
            if (postService.count() > 0) {
                return;
            }

            postService.write("제목1", "내용1");

            if (true) {
                throw new RuntimeException("테스트 예외");
            }

            postService.write("제목2", "내용2");

        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        }
    }

    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }
}
