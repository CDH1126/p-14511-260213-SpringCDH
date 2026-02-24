package com.back.global.initData;

import com.back.domain.post.entity.Post;
import com.back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Profile("test")
public class TestInitData {

    private final PostService postService;

    @Bean
    ApplicationRunner testInitDataRunner() {
        return args -> {

            Post p1 = postService.write("테스트 제목1", "테스트 내용1");
            Post p2 = postService.write("테스트 제목2", "테스트 내용2");

        };
    }
}
