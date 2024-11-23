package com.example.socialmedia.service;

import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.UserEntity;
import com.example.socialmedia.mapper.UserMapper;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
// api security
// reverse proksy (spring cloud gateway)
// material UI library
// low code material UI open source tool UI

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    public ResponseEntity<Object> createUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(userMapper.toEntity(userDto));
        return ResponseEntity.ok(userEntity);
    }

    public ResponseEntity<List<UserEntity>> getAllUsersByName(String name) {
        List<UserEntity> userEntities = userRepository.findUserEntitiesByFirstName(name);
        return ResponseEntity.ok(userEntities);
    }

    public ResponseEntity<Object> checkForLogin(String username, String password) {

        UserEntity userEntity = userRepository.findByUserNameAndPassword(username, password);
        String token = jwtService.generateToken(userEntity);
        System.out.println(jwtService.extractId(token));
        return ResponseEntity.ok(token);
    }

}

