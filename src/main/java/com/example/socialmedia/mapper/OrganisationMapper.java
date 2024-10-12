package com.example.socialmedia.mapper;

import com.example.socialmedia.dto.OrganisationDto;
import com.example.socialmedia.entity.Organisation;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganisationMapper {
    Organisation toEntity(OrganisationDto organisationDto);

    OrganisationDto toDto(Organisation organisation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Organisation partialUpdate(OrganisationDto organisationDto, @MappingTarget Organisation organisation);
}