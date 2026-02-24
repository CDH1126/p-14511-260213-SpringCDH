package com.back.global.initData;

import com.back.domain.member.entity.Member;
import com.back.domain.member.service.MemberService;
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
    private final MemberService memberService;

    @Bean
    ApplicationRunner testInitDataRunner() {
        return args -> {

            Member author1 = memberService.findById(3).get();
            Member author2 = memberService.findById(4).get();

            Post p1 = postService.write(author1, "테스트 제목1", "테스트 내용1");
            Post p2 = postService.write(author2, "테스트 제목2", "테스트 내용2");
        };
    }
}
