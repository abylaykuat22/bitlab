package kz.bitlab.g139rest.service;

import kz.bitlab.g139rest.dto.ChangePasswordDto;
import kz.bitlab.g139rest.dto.UserCreateDto;
import kz.bitlab.g139rest.dto.UserResponseDto;
import kz.bitlab.g139rest.entity.User;
import kz.bitlab.g139rest.mapper.UserMapper;
import kz.bitlab.g139rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserCreateDto dto) throws BadRequestException {
        User existUser = findByEmail(dto.getEmail());
        if (existUser != null) {
            throw new BadRequestException("Username already exists");
        }

        User user = UserMapper.INSTANCE.toEntity(dto);
        User savedUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDto(savedUser);
    }

    public UserResponseDto getUserById(Long id) throws BadRequestException {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found"));
        return UserMapper.INSTANCE.toDto(user);
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public void changePassword(ChangePasswordDto dto) throws BadRequestException {
        User user = userRepository.findById(dto.getId()).orElse(null);
        if (user == null) {
            throw new BadRequestException("User not found");
        }

        if (!user.getPasswordHash().equals(dto.getCurrentPassword())) {
            throw new BadRequestException("Wrong password");
        }

        user.setPasswordHash(dto.getNewPassword());
        userRepository.save(user);
    }
}
