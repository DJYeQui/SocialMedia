package com.example.socialmedia.dto;

import com.example.socialmedia.entity.UserEntity;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.example.socialmedia.entity.Organisation}
 */
@Value
public class OrganisationDto implements Serializable {
    String name;
    String description;
    String date;
    String location;
    String type; // for labeling later
    String status;
    Set<UserEntity> userEntities;
}