package kz.bitlab.g130restproject.service;

import kz.bitlab.g130restproject.entity.Post;

import java.util.List;

public interface PostService {

    Post getPostById(Long id);

    List<Post> getAllPosts();

    void createPost(Post post);

    void updatePost(Post post);

    void deletePostById(Long id);

    void updateAuthor(Long id, String author);
}
