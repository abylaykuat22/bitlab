package kz.bitlab.bootcamp.bitlab.api;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.services.FriendsService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/friends_controller")
@RequiredArgsConstructor
public class FriendsController {
    private final UserService userService;
    private final FriendsService friendsService;

    @GetMapping
    public Courier getAllUsers(){
        Courier courier = new Courier();
        courier.setGetAllUsers(userService.getAllUsers());
        courier.setGetUsersAvatars(userService.getUsersAvatars());
        courier.setCurrentUser(userService.getCurrentUser());
        return courier;
    }

    @PostMapping
    public void addFriends(@RequestBody Courier courier){
        friendsService.addFriend(courier);
    }

    @GetMapping(value = "/friendsList")
    public Courier getFriendsList(){
        return friendsService.getFriendsList();
    }

    @GetMapping(value = "/friendRequests")
    public Courier getFriendRequests(){
        return friendsService.getFriendRequests();
    }

    @PostMapping(value = "/confirmAdd")
    public void confirmAddFriends(@RequestBody Courier courier){
        friendsService.confirmAddFriend(courier);
    }
}

