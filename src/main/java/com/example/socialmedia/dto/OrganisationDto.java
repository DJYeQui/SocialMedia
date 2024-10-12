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
    String organisationName;
    String organzationDescription;
    String organisationDate;
    String organisationLocation;
    String organisationType;
    String organisationStatus;
    Set<UserEntity> userEntities;
}