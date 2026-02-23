package com.back.domain.post.service;

import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Bean 객체 등록
public class PostService {

    @Autowired // Bean 객체로 등록하지 않으면 스프링부트가 관리하지 않음
    private PostRepository postRepository;

    public Post write(String title, String content) {

        Post post = new Post(title,content);
        return postRepository.save(post);
    }

    public Post findById(int id) {
        return postRepository.findById(id).orElse(null); // 없을 경우 null 반환
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public long count() {
        return postRepository.count();
    }

}
