package com.example.socialmedia.service;

import com.example.socialmedia.dto.OrganisationDto;
import com.example.socialmedia.entity.Organisation;
import com.example.socialmedia.mapper.OrganisationMapper;
import com.example.socialmedia.repository.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final OrganisationRepository organisationRepository;
    private final OrganisationMapper organisationMapper;

    public ResponseEntity<Object> createOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = organisationRepository.save(organisationMapper.toEntity(organisationDto));
        return ResponseEntity.ok().body(organisation);
    }
}
