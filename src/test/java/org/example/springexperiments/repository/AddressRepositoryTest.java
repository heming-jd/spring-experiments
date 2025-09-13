package org.example.springexperiments.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments.dox.Address;
import org.example.springexperiments.dto.AddressUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Test
    public void saveAddress(){
        Address address=Address.builder()
                .detail("丹青")
                .userId("1415891113103097856")
                .build();
        addressRepository.save(address);
    }
    @Test
    public void fimdAddressByUserTd(){
        List<Address> addresses=addressRepository.findByUserId("1415891113103097856");
        log.info("addresses:{}",addresses);
    }
    @Test
    public void findAddressUserByAddressId(){
        AddressUser addressUser=addressRepository.findAddressUserByAddressId("1415921150552473600");
        log.info("addressUser:{}",addressUser);
    }

}
