package com.jpop4.service;

import com.jpop4.domain.UserDto;
import com.jpop4.exceptions.UserNotFoundException;
import com.jpop4.mapper.UserMapper;
import com.jpop4.repository.UserRepository;
import com.jpop4.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService {

    private static final String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User details are not found with given id: ";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDto getUserDetails(BigInteger userId) {
        return userMapper.toUserDto(
                userRepository.findById(userId)
                        .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE + userId))
        );
    }

    public List<UserDto> getAllUserDetails() {
        return userMapper.toUserDtos(userRepository.findAll());
    }

    public boolean addUserDetails(UserDto userDto) {
        userRepository.save(userMapper.toUser(userDto));
        return true;
    }

    public boolean deleteUserDetails(BigInteger userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE + userId);
        }

        userRepository.deleteById(userId);
        return true;
    }

    public UserDto updateUserDetails(UserDto userDto) {
        if (!userRepository.existsById(userDto.getId())) {
            throw new UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE + userDto.getId());
        }

        userRepository.save(userMapper.toUser(userDto));
        return userDto;
    }
}
