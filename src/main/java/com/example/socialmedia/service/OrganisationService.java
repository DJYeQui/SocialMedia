package com.example.socialmedia.service;

import com.example.socialmedia.dto.OrganisationDto;
import com.example.socialmedia.entity.Organisation;
import com.example.socialmedia.entity.UserEntity;
import com.example.socialmedia.mapper.OrganisationMapper;
import com.example.socialmedia.repository.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganisationService {

    private final OrganisationRepository organisationRepository;
    private final OrganisationMapper organisationMapper;

    public ResponseEntity<Object> createOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = organisationRepository.save(organisationMapper.toEntity(organisationDto));
        return ResponseEntity.ok().body(organisation);
    }

    public ResponseEntity<Object> addParticipantToOrganisation(UserEntity userEntity, Long id) {
        try {
            Organisation organisation = organisationRepository.findById(id).orElseThrow();
            System.out.println("add participant to organisation");
            organisation.getUserEntities().add(userEntity);
            return ResponseEntity.ok().body(organisationMapper.toDto(organisationRepository.save(organisation)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.accepted().build();
        }
    }

    public ResponseEntity<Object> findOrganisation(Long id) {

        Optional<Organisation> organisation = organisationRepository.findById(id);
        if (organisation.isPresent()) return ResponseEntity.ok().body(organisation);
        System.out.println("findOrganisation function returns null it could not find organisation with that id");
        return ResponseEntity.badRequest().build();

    }
}
