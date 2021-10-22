package com.abantej.web.service;

import com.abantej.web.dao.ProfileDao;
import com.abantej.web.dto.ProfileDto;
import com.abantej.web.model.Profile;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ProfileService {

    private ProfileDao profileDao;

    private ModelMapper modelMapper;

    @Autowired
    public ProfileService(ProfileDao profileDao, ModelMapper modelMapper) {
        this.profileDao = profileDao;
        this.modelMapper = modelMapper;
    }

    public List<ProfileDto> getAllProfiles() {
        List<Profile> allProfiles = profileDao.getAllProfiles();
        Type type = new TypeToken<List<ProfileDto>>() {}.getType();
        List<ProfileDto> profileDtos = modelMapper.map(allProfiles, type);
        return profileDtos;
    }

    public void addProfile(ProfileDto profileDto) {
        Profile profile = modelMapper.map(profileDto, Profile.class);
        profileDao.addProfile(profile);
    }

    public ProfileDto getProfile(Long id) {
        Profile profile = profileDao.getProfile(id);
        if (profile == null) {
            return null;
        }
        return modelMapper.map(profile, ProfileDto.class);
    }

    public void updateProfile(ProfileDto profileDto) {
        Profile profile = modelMapper.map(profileDto, Profile.class);
        profileDao.updateProfile(profile);
    }

    public void deleteProfile(Long id) {
        profileDao.deleteProfile(id);
    }
}
