package g145.g145market.controller;

import g145.g145market.dto.UserCreateDto;
import g145.g145market.dto.UserResponse;
import g145.g145market.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List getUsers() {
        return null;
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserCreateDto dto) {
        return ResponseEntity.status(201).body(userService.addUser(dto));
    }
}
