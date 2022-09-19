package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.services.LikesService;
import kz.bitlab.bootcamp.bitlab.services.NewsService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/likes")
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;
    private final UserService userService;
    private final NewsService newsService;
    private final UserMapper userMapper;

    @GetMapping(value = "{id}")
    public List<UserDto> getLikedUsers(@PathVariable(name = "id") Long id){
        return likesService.getLikedUsers(id);
    }

    @PostMapping
    public String addLike(@RequestBody Courier courier){
        return userService.addDeleteLike(courier.getId());
    }
    @PostMapping(value = "/likeNews")
    public String addDeleteNewsLike(@RequestBody Courier courier){
        return newsService.addDeleteNewsLike(courier.getId());
    }
    @DeleteMapping(value = "/picture")
    public void deletePicture(@RequestBody Courier courier){
        likesService.deletePicture(courier.getId());
    }
}
