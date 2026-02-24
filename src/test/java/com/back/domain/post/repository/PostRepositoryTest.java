package com.back.domain.post.repository;

import com.back.domain.post.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    @Rollback
    void t1 () {
        Post post = postRepository.findById(2).get();

        assertThat(post.getId()).isEqualTo(2);
        assertThat(post.getTitle()).isEqualTo("제목2");
        assertThat(post.getContent()).isEqualTo("내용2");
    }


    @Test
    @Transactional
    @Rollback
    void t2() {
        Post post = new Post("제목3", "내용3");
        Post savedPost = postRepository.save(post);

        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getTitle()).isEqualTo("제목3");
        assertThat(savedPost.getContent()).isEqualTo("내용3");
    }

    @Test
    @Transactional
    @Rollback
    void t3() {
        long cnt = postRepository.count();
        assertThat(cnt).isEqualTo(2);
    }

}
