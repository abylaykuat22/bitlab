package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.services.CommentService;
import kz.bitlab.bootcamp.bitlab.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/comment")
@RequiredArgsConstructor
public class CommentController {
    private final NewsService newsService;
    private final CommentService commentService;

    @PostMapping
    public void addComment(@RequestBody Courier courier){
        newsService.addComment(courier);
    }

    @DeleteMapping
    public void deleteComment(@RequestBody Courier courier){
        commentService.deleteCommentById(courier.getId());
    }
}
