package com.example.socialmedia.dto;

import com.example.socialmedia.entity.UserEntity;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */
@Value
public class UserDto implements Serializable {
    String firstName;
    String lastName;
    String userName;
    String email;
    String password;
    String phoneNumber;
}