package com.abantej.web;

import com.abantej.web.dao.ProfileDao;
import com.abantej.web.model.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    @Autowired
    private ProfileDao profileDao;

    private static final Logger log = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        log.info("Selecting all profiles");

//        List<Profile> profiles = jdbcTemplate.query("select * from profile", new ProfileMapper());
        List<Profile> profiles = profileDao.getAllProfiles();

        profiles.stream().forEach(p -> System.out.println(p));
    }


}
