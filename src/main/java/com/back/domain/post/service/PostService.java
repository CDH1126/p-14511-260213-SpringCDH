package com.back.domain.post.service;

import com.back.domain.member.entity.Member;
import com.back.domain.post.entity.Post;
import com.back.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Component 와 같지만 직관성을 위해 변경
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(Member author, String title, String content) {

        Post post = new Post(author, title, content);
        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);

        // return postRepository.save(post);
        return post; // 더티체킹 방식으로 재정의
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public long count() {
        return postRepository.count();
    }

}
