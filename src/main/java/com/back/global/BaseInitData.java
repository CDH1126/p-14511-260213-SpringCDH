package com.back.global;


import com.back.domain.wiseSaying.entity.Post;
import com.back.domain.wiseSaying.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired // S B 가 컨테이너에서 해당 타입을 찾아 객체에 넣어줌
    private PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner() {
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {

            if(postRepository.count() > 0) {
                return;
            }

            System.out.println("초기 데이터를 로딩합니다.");

            Post post1 = new Post("제목1", "내용1");
            postRepository.save(post1);

        };
    }

}