package com.example.jpa.domain.post.post.service;

import com.example.jpa.domain.post.post.entity.Post;
import com.example.jpa.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(String title, String body) {
        // 1. Post 조립
        Post post = Post.builder()
                .title(title)
                .body(body)
                .build();

        //post.setId(1L);
//        post.setCreateDate(LocalDateTime.now());
//        post.setModifiedDate(LocalDateTime.now());
//        post.setTitle(title);
//        post.setBody(body);
        // 2. repository에게 넘김
        postRepository.save(post);
        // 3. DB 반영
        return post;
    }

    @Transactional
    public Post modify(Post post, String title, String body) {
        post.setTitle(title);
        post.setBody(body);

        return post;
    }

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public void modify2(long id, String title, String body) {
        Post post = postRepository.findById(id).get();

        post.setTitle(title);
        post.setBody(body);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
