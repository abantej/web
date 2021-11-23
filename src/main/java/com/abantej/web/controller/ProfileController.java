package com.abantej.web.controller;

import com.abantej.web.controller.form.ProfileForm;
import com.abantej.web.dto.ProfileDto;
import com.abantej.web.service.ProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    private ProfileService profileService;

    private ModelMapper modelMapper;

    @Autowired
    public ProfileController(ProfileService profileService, ModelMapper modelMapper) {
        this.profileService = profileService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/profiles")
    public ResponseEntity<Object> getAllProfiles() {
        List<ProfileDto> allProfiles = profileService.getAllProfiles();
        return ResponseEntity.ok()
                .body(allProfiles);
    }

    @PostMapping("/profiles")
    public ResponseEntity<Object> addProfile(@RequestBody ProfileForm profileForm) {
        ProfileDto profileDto = modelMapper.map(profileForm, ProfileDto.class);
        profileService.addProfile(profileDto);
        return ResponseEntity.ok()
                .body("Profile added successfully");
    }

    @PutMapping("/profiles/{id}")
    public ResponseEntity<Object> updateProfile(@PathVariable Long id, @RequestBody ProfileForm profileForm) {
        ProfileDto profileDto = modelMapper.map(profileForm, ProfileDto.class);
        profileDto.setId(id);
        profileService.updateProfile(profileDto);
        return ResponseEntity.ok()
                .body("Profile updated successfully");
    }

    @DeleteMapping("/profiles/{id}")
    public ResponseEntity<Object> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.ok()
                .body("Profile deleted successfully.");
    }
}
