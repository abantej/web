package com.abantej.web.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileMapper implements RowMapper<Profile> {
    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Profile.builder()
                .id(rs.getLong("id"))
                .firstName(rs.getString("first_name"))
                .middleName(rs.getString("middle_name"))
                .lastName(rs.getString("last_name"))
                .birthDate(rs.getDate("birth_date"))
                .build();
    }
}
