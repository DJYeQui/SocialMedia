package com.example.socialmedia.controller;

import com.example.socialmedia.constants.ApiConstants;
import com.example.socialmedia.dto.OrganisationDto;
import com.example.socialmedia.entity.Organisation;
import com.example.socialmedia.entity.UserEntity;
import com.example.socialmedia.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstants.ORGANISATION_API)
@RequiredArgsConstructor

public class OrganisationController {
    private final OrganisationService organisationService;

    @PostMapping("/generateOrganisation")
    public ResponseEntity<Object> generateOrganisation(@RequestBody OrganisationDto organisationDto) {
        return organisationService.createOrganisation(organisationDto);
    }

    @GetMapping("/findOrganisation")
    public ResponseEntity<Object> findOrganisation(@RequestParam Long id) {
        return organisationService.findOrganisation(id);
    }

    @PutMapping("/addParticipentOrganisation")
    public ResponseEntity<Object> addParticipantOrganisation(@RequestParam Long organisationId, @RequestBody UserEntity userEntity) {
        return organisationService.addParticipantToOrganisation(userEntity,organisationId);
    }
}
