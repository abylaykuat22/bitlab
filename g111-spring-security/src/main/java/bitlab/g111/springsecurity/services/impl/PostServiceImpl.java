package bitlab.g111.springsecurity.services.impl;

import bitlab.g111.springsecurity.models.Post;
import bitlab.g111.springsecurity.repositories.PostRepository;
import bitlab.g111.springsecurity.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  private PostRepository postRepository;

  @Override
  public Post addPost(Post post) {
    return postRepository.save(post);
  }

  @Override
  public List<Post> getPosts() {
    return postRepository.findAll();
  }

  @Override
  public Post getPostById(Long id) {
    return postRepository.findById(id).orElseThrow();
  }

  @Override
  public Post editPost(Post post) {
    return postRepository.save(post);
  }
}
