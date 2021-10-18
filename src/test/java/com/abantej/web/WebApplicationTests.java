package com.abantej.web;

import com.abantej.web.dao.ProfileDao;
import com.abantej.web.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WebApplicationTests {

    @BeforeEach
    public void setup() {
    }

    @Autowired
    private ProfileDao profileDao;

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
        Profile newProfile = profileDao.getProfile(3L);
        assertNotNull(newProfile);
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
        profileDao.deleteProfile(2L);
        Profile profile = profileDao.getProfile(2L);
        assertNull(profile);
    }
}
