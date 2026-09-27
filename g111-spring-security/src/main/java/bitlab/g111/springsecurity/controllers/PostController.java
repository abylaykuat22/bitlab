package bitlab.g111.springsecurity.controllers;

import bitlab.g111.springsecurity.models.Post;
import bitlab.g111.springsecurity.services.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

  @Autowired
  private PostService postService;

  @PostMapping
  public Post addPost(@RequestBody Post post) {
    return postService.addPost(post);
  }

  @GetMapping
  public List<Post> getPosts() {
    return postService.getPosts();
  }

  @GetMapping("{id}")
  public Post getPost(@PathVariable Long id) {
    return postService.getPostById(id);
  }

  @PutMapping
  public Post editPost(@RequestBody Post post) {
    return postService.editPost(post);
  }
}
