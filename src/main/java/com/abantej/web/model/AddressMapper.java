package com.abantej.web.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Address.builder()
                .id(rs.getLong("id"))
                .profileId(rs.getLong("profile_id"))
                .address(rs.getString("address"))
                .city(rs.getString("city"))
                .state(rs.getString("state"))
                .zip(rs.getString("zip"))
                .country(rs.getString("country"))
                .build();
    }
}
