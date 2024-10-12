package com.example.socialmedia.controller;

import com.example.socialmedia.constants.ApiConstants;
import com.example.socialmedia.dto.OrganisationDto;
import com.example.socialmedia.entity.Organisation;
import com.example.socialmedia.repository.OrganisationRepository;
import com.example.socialmedia.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.ORGANISATION_API)
@RequiredArgsConstructor

public class OrganisationController {
    private final OrganisationService organisationService;

    @PostMapping("/generateOrganisation")
    public ResponseEntity<Object> generateOrganisation(@RequestBody OrganisationDto organisationDto) {
        return organisationService.createOrganisation(organisationDto);
    }
}
