package kz.bitlab.G115security.contoller;

import java.util.List;
import kz.bitlab.G115security.dtos.UserCreate;
import kz.bitlab.G115security.dtos.UserUpdate;
import kz.bitlab.G115security.dtos.UserView;
import kz.bitlab.G115security.entity.User;
import kz.bitlab.G115security.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;
  @GetMapping("{id}")
  public UserView getUser(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @PostMapping
  public UserView addUser(@RequestBody UserCreate userCreate) {
    return userService.addUser(userCreate);
  }

  @PutMapping
  public UserView updateUser(@RequestBody UserUpdate userUpdate) {
    return userService.updateUser(userUpdate);
  }

  @GetMapping
  public List<UserView> getUsers() {
    return userService.getUsers();
  }

}
