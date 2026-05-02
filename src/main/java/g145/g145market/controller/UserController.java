package g145.g145market.controller;

import g145.g145market.dto.ChangePasswordDto;
import g145.g145market.dto.UserCreateDto;
import g145.g145market.dto.UserResponse;
import g145.g145market.service.ExcelService;
import g145.g145market.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ExcelService excelService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserCreateDto dto) {
        return ResponseEntity.status(201).body(userService.register(dto));
    }

    @PostMapping("/change-password")
    public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordDto dto) {
        userService.changePassword(dto);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/export")
    public ResponseEntity<?> exportUsers() {
        ByteArrayInputStream bais = excelService.exportUsers();
        InputStreamResource resource = new InputStreamResource(bais);
        final String filename = "users.xlsx";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }

    @PostMapping("/import")
    public List<UserResponse> importUsers(MultipartFile file) {
        return excelService.importUsers(file);
    }
}
