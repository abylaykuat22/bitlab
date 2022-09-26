package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/picture")
@RequiredArgsConstructor
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/user")
    public UserDto getUser(){
        return userMapper.toDto(userService.getCurrentUser());
    }
    @GetMapping
    public List<Picture> allPictures(){
        return pictureService.getPictures();
    }
    @GetMapping(value = "/likes")
    public Courier pictureLikes(){
        return userService.pictureLikes();
    }
}
