package bitlab.g111.springsecurity.services;

import bitlab.g111.springsecurity.models.Post;
import java.util.List;

public interface PostService {
  Post addPost(Post post);
  List<Post> getPosts();

  Post getPostById(Long id);

  Post editPost(Post post);
}
