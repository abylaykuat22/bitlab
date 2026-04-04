package g145.g145market.service;

import g145.g145market.dto.UserCreateDto;
import g145.g145market.dto.UserResponse;
import g145.g145market.entity.User;
import g145.g145market.exception.EmailUniqueException;
import g145.g145market.exception.PhoneNumberUniqueException;
import g145.g145market.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserResponse addUser(UserCreateDto dto) {
        log.info("STARTED addUser. Params: {}", dto);

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailUniqueException("Email already exists with email " + dto.getEmail());
        }

        if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new PhoneNumberUniqueException("Phone number already exists with phone number " + dto.getPhoneNumber());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        User user = User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .birthdate(LocalDate.parse(dto.getBirthdate(), formatter))
                .build();
        User savedUser = userRepository.save(user);

        UserResponse userResponse = UserResponse.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .address(savedUser.getAddress())
                .birthdate(savedUser.getBirthdate().toString())
                .createdAt(savedUser.getCreatedAt().toString())
                .build();

        log.info("COMPLETED addUser. Params: {}", savedUser);
        return userResponse;
    }

}
