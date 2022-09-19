package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
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

    @GetMapping
    public Courier getNewsData(){
        return newsService.getNewsData();
    }

    @DeleteMapping
    public void deleteNews(@RequestBody Courier courier){
        newsService.deleteNewsById(courier.getId());
    }
}
