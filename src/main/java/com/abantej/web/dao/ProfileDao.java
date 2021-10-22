package com.abantej.web.dao;

import com.abantej.web.model.Profile;
import com.abantej.web.model.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProfileDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Profile> getAllProfiles() {
        return jdbcTemplate.query("select * from profile",
                new ProfileMapper()
        );
    }

    public void addProfile(Profile profile) {
        final String sql = "insert into profile(first_name, middle_name, last_name, birth_date) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, profile.getFirstName(), profile.getMiddleName(), profile.getLastName(), profile.getBirthDate());
    }

    public Profile getProfile(Long id) {
        try {
            final String sql = "select * from profile where id = ?";
            return jdbcTemplate.queryForObject(sql, new ProfileMapper(), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateProfile(Profile profile) {
        final String sql = "update profile set first_name = ?, middle_name = ?, last_name = ?, birth_date = ? where id = ?";
        jdbcTemplate.update(sql, profile.getFirstName(), profile.getMiddleName(), profile.getLastName(), profile.getBirthDate(), profile.getId());
    }

    public void deleteProfile(Long id) {
        final String sql = "delete from profile where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
