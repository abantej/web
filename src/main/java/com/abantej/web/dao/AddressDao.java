package com.abantej.web.dao;

import com.abantej.web.model.Address;
import com.abantej.web.model.AddressMapper;
import com.abantej.web.model.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AddressDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Address> getAllAddress() {
        return jdbcTemplate.query("select * from address", new AddressMapper());
    }

    public void addAddress(Address address) {
        final String sql = "insert into address(profile_id, address, city, state, zip, country) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, address.getProfileId(), address.getAddress(), address.getCity(), address.getState(), address.getZip(), address.getCountry());
    }

    public Address getAddress(Long id) {
        try {
            final String sql = "select * from address where profile_id = ?";
            return jdbcTemplate.queryForObject(sql, new AddressMapper(), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateAddress(Address address) {
        final String sql = "update address set address = ?, city = ?, state = ?, zip = ?, country = ? where profile_id = ?";
        jdbcTemplate.update(sql, address.getAddress(), address.getCity(), address.getState(), address.getZip(), address.getCountry(), address.getProfileId());
    }

    public void deleteAddress(Long id) {
        final String sql = "delete from address where profile_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
