package com.pelin.authenticationserver.service;

import com.pelin.authenticationserver.dto.UserDto;
import static com.pelin.authenticationserver.mapper.UserMapper.USER_MAPPER;

import com.pelin.authenticationserver.model.Role;
import com.pelin.authenticationserver.model.User;
import com.pelin.authenticationserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserDto> getUserById(String userId) {
       Optional<User> user = userRepository.findById(userId);
       if(user.isPresent())
            return Optional.ofNullable(USER_MAPPER.convertToUserDto(user.get()));
        return Optional.empty();
    }
}
