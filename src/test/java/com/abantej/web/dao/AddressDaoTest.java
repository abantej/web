package com.abantej.web.dao;

import com.abantej.web.model.Address;
import com.abantej.web.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@Transactional
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Test
    public void getAllAddress() {
        List<Address> addresses = addressDao.getAllAddress();
        assertTrue(addresses.size() == 4);
    }

    @Test
    public void addAddress() {
        Address newAddress = Address.builder()
                .profileId(3L)
                .address("Jurong")
                .city("Singapore")
                .state("Singapore")
                .zip("123456")
                .country("Singapore")
                .build();
        addressDao.addAddress(newAddress);
        List<Address> addresses = addressDao.getAllAddress();
        assertTrue(addresses.size() == 5);
    }

    @Test
    public void getAddress() {
        Address address = addressDao.getAddress(1L);
        assertNotNull(address);
    }

    @Test
    public void updateAddress() {
        final Address address = Address.builder()
                .profileId(1L)
                .address("Changi Business Park")
                .city("Pasir Ris")
                .state("Singapore")
                .zip("501001")
                .country("Singapore")
                .build();
        addressDao.updateAddress(address);
        List<Address> addresses = addressDao.getAllAddress();
        final Address updatedAddress = addressDao.getAddress(address.getProfileId());
        assertEquals(updatedAddress.getAddress(), address.getAddress());
        assertEquals(updatedAddress.getCity(), address.getCity());
        assertEquals(updatedAddress.getState(), address.getState());
        assertEquals(updatedAddress.getZip(), address.getZip());
        assertEquals(updatedAddress.getCountry(), address.getCountry());
    }

    @Test
    public void deleteAddress() {
        addressDao.deleteAddress(7L);
        Address address = addressDao.getAddress(7L);
        assertNull(address);
    }
}
