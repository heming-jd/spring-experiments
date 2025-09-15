package org.example.springexperiments.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments.dto.UserAddresses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserAddressesRepositoryTest {
    @Autowired
    private UserAddressesRepository userAddressesRepository;
    @Test
    public void test() {
        UserAddresses userAddresses = userAddressesRepository.findUserAddressesById("1415921099235164160");
        log.info("userAddresses: {}", userAddresses);
    }
}
