package kz.bitlab.g130restproject.service.impl;

import kz.bitlab.g130restproject.entity.Post;
import kz.bitlab.g130restproject.repository.PostRepository;
import kz.bitlab.g130restproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found " + id));
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(Long id, String author) { // id = 5
        Post post = getPostById(id);
        post.setAuthor(author);
        postRepository.save(post);
    }
}
