package g145.g145market.service;

import g145.g145market.dto.ChangePasswordDto;
import g145.g145market.dto.UserCreateDto;
import g145.g145market.dto.UserResponse;
import g145.g145market.entity.User;
import g145.g145market.exception.BadRequestException;
import g145.g145market.exception.EmailUniqueException;
import g145.g145market.exception.PhoneNumberUniqueException;
import g145.g145market.mapper.UserMapper;
import g145.g145market.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(UserCreateDto dto) {
        log.info("STARTED addUser. Params: {}", dto);

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailUniqueException("Email already exists with email " + dto.getEmail());
        }

        if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new PhoneNumberUniqueException("Phone number already exists with phone number " + dto.getPhoneNumber());
        }

        User user = UserMapper.INSTANCE.toEntity(dto);
        user.setRoles(List.of(roleService.getUserRole()));
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        UserResponse userResponse = UserMapper.INSTANCE.toDto(savedUser);

        log.info("COMPLETED addUser. Params: {}", savedUser);
        return userResponse;
    }

    public User currentUser() {
        try {
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new RuntimeException("Current user is not authenticated");
        }
    }

    public void changePassword(@Valid ChangePasswordDto dto) {
        log.info("STARTED changePassword. Params: {}", dto);

        User user = currentUser();
        if (!passwordEncoder.matches(dto.getCurrentPassword(), user.getPassword())) {
            throw new BadRequestException("Incorrect password");
        }

        if (!dto.getNewPassword().equals(dto.getReNewPassword())) {
            throw new BadRequestException("Incorrect password");
        }

        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));

        userRepository.save(user);
    }
}
