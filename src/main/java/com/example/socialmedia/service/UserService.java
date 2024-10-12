package com.example.socialmedia.service;

import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.UserEntity;
import com.example.socialmedia.mapper.UserMapper;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public ResponseEntity<Object> createUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(userMapper.toEntity(userDto));
        return ResponseEntity.ok(userEntity);
    }

    public ResponseEntity<List<UserEntity>> getAllUsersByName(String name) {
        List<UserEntity> userEntities = userRepository.findUserEntitiesByFirstName(name);
        return ResponseEntity.ok(userEntities);
    }
}
