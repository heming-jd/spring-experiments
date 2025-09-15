package org.example.springexperiments.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UnameAcountTest {
    @Autowired
    private UnameAcountRepository unameAcountRepository;
    @Test
    void test() {
        unameAcountRepository.findAllUnameAcount().forEach(unameAcount -> log.info(unameAcount.toString()));
    }
}
