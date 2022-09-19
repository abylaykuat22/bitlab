package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import liquibase.pro.packaged.P;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "/currentUserData")
    public Courier currentUserData(){
        return userService.getCurrentUserData();
    }

    @PostMapping
    public String addUser (@RequestBody Courier courier){
        if (userService.addUser(courier)!=null){
            return "success";
        }
        return "error2";
    }

    @PostMapping(value = "/checkCW")
    public User checkCW(@RequestBody Courier courier){
        if (userService.checkCodeWord(courier)!=null){
            return userService.getUserByEmail(courier.getEmail());
        }
        return null;
    }

    @PostMapping(value = "/newPassword")
    public boolean newPassword(@RequestBody Courier courier){
        if (userService.resetAddNewPassword(courier)!=null){
            return true;
        }
        return false;
    }

    @GetMapping(value = "{id}")
    public UserDto getUserDto(@PathVariable(name = "id") Long id){
        return userService.getUserDto(id);
    }

    @PutMapping
    public String changePassword(@RequestBody Courier courier){
        if (userService.changePassword(courier)!=null){
            return "success";
        }
        return "error";
    }

}
