package com.example.socialmedia.controller;

import com.example.socialmedia.constants.ApiConstants;
import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.UserEntity;
import com.example.socialmedia.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.USER_API)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;



    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

}
