package com.example.socialmedia.dto;

import com.example.socialmedia.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link UserEntity}
 */

@AllArgsConstructor
@Getter
public class UserDto implements Serializable {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String email;
    private final String password;
    private final int phoneNumber;
}