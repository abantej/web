package com.abantej.web.dao;

import com.abantej.web.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ProfileDaoTest {

    @Autowired
    private ProfileDao profileDao;

    @Test
    public void getAllProfiles() {
        List<Profile> allProfiles = profileDao.getAllProfiles();
        assertTrue(allProfiles.size() > 0);
    }

    @Test
    public void addProfile() {
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2000, 05, 30);

        Profile profile = Profile.builder()
                .firstName("Gyro")
                .middleName("Dragon")
                .lastName("Copter")
                .birthDate(birthDate.getTime())
                .build();

        profileDao.addProfile(profile);
    }

    @Test
    public void getProfile() {
        Profile profile = profileDao.getProfile(1L);
        assertNotNull(profile);
    }

    @Test
    public void updateProfile() {
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(2000, 05, 30);

        Profile profile = Profile.builder()
                .id(1L)
                .firstName("Ember")
                .middleName("Panot")
                .lastName("Spirit")
                .birthDate(birthDate.getTime())
                .build();

        profileDao.updateProfile(profile);
        Profile updatedProfile = profileDao.getProfile(1L);
        assertEquals(profile.getMiddleName(), updatedProfile.getMiddleName());
    }

    @Test
    public void deleteProfile() {
        profileDao.deleteProfile(5L);
        Profile profile = profileDao.getProfile(5L);
        assertNull(profile);
    }
}
