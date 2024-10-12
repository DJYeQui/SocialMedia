package com.example.socialmedia.controller;

import com.example.socialmedia.constants.ApiConstants;
import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.UserEntity;
import com.example.socialmedia.service.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.USER_API)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Invalid user form " + bindingResult.getAllErrors());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return userService.createUser(userDto);
    }

    @GetMapping("/usersBy{name}")
    public ResponseEntity<List<UserEntity>> getUsersById(@PathVariable String name) {
        return userService.getAllUsersById(name);
    }

}
