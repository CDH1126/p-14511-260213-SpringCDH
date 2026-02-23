package com.back.global;


import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import com.back.domain.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired // S B 가 컨테이너에서 해당 타입을 찾아 객체에 넣어줌
    private PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            work1();
            work2();
        };
    }

    void work1() {

        if(postService.count() > 0) {
            return;
        }
        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }

}