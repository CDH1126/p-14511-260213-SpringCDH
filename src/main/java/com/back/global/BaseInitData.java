package com.back.global;


import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Bean
    ApplicationRunner initDataRunner() {
        // ApplicationRunner - 스프링부트의 초기 작업 지시
        return args -> {
            System.out.println("초기 데이터를 로딩합니다.");
        };
    }

}