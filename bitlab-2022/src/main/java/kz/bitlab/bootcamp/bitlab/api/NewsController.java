package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.CommentDto;
import kz.bitlab.bootcamp.bitlab.dto.NewsDto;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.NewsMapper;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.model.Comment;
import kz.bitlab.bootcamp.bitlab.model.News;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.services.NewsService;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/news")
@RequiredArgsConstructor
public class NewsController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "/list")
    public List<NewsDto> getAllNews(){
        return newsMapper.toDtoList(newsService.getNews());
    }
    @GetMapping(value = "{id}")
    public List<NewsDto> getUserNews(@PathVariable(name = "id") Long id){
        return newsService.userNews(id);
    }
    @GetMapping(value = "/comments/{id}")
    public Courier getNewsComments(@PathVariable(name = "id") Long id){
        Courier courier = new Courier();
        courier.setCommentDtoList(newsService.comments(id));
        courier.setUserDto(userMapper.toDto(userService.getCurrentUser()));
        courier.setGetUsersAvatars(userService.getUsersAvatars());
        return courier;
    }

    @GetMapping(value = "/comments")
    public Courier getNewsList(){
        return newsService.newsComments();
    }
    @GetMapping(value = "/pictures")
    public Courier getNewsPictures(){
        return newsService.newsPictures();
    }

    @GetMapping(value = "/likes")
    public List<NewsDto> getNewsLikes(){
        return newsMapper.toDtoList(newsService.getNews());
    }

    @DeleteMapping
    public void deleteNews(@RequestBody Courier courier){
        newsService.deleteNewsById(courier.getId());
    }
}
