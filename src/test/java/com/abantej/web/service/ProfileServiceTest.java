package com.abantej.web.service;

import com.abantej.web.dto.ProfileDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    @Test
    public void getAllProfiles() {
        List<ProfileDto> allProfiles = profileService.getAllProfiles();
        assertTrue(allProfiles.size() > 0);
    }

    @Test
    public void addProfile() {
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2000, 05, 30);

        ProfileDto profileDto = ProfileDto.builder()
                .firstName("Gyro")
                .middleName("Dragon")
                .lastName("Copter")
                .birthDate(birthDate.getTime())
                .build();

        profileService.addProfile(profileDto);
        ProfileDto newProfileDto = profileService.getProfile(3L);
        assertNotNull(newProfileDto);
    }

    @Test
    public void getProfile() {
        ProfileDto profileDto = profileService.getProfile(1L);
        assertNotNull(profileDto);
    }

    @Test
    public void updateProfile() {
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2000, 05, 30);

        ProfileDto profileDto = ProfileDto.builder()
                .id(1L)
                .firstName("Ember")
                .middleName("Panot")
                .lastName("Spirit")
                .birthDate(birthDate.getTime())
                .build();

        profileService.updateProfile(profileDto);
        ProfileDto updatedProfileDto = profileService.getProfile(1L);
        assertEquals(profileDto.getMiddleName(), updatedProfileDto.getMiddleName());
    }

    @Test
    public void deleteProfile() {
        profileService.deleteProfile(2L);
        ProfileDto profileDto = profileService.getProfile(2L);
        assertNull(profileDto);
    }
}
