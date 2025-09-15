package org.example.springexperiments.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void saveUser(){
        User user=User.builder()
                .name("test1")
                .build();
        userRepository.save(user);//userRepository.save(new User("test","test","test"));
    }
    @Test
    public void deleteUser(){
        userRepository.deleteById("1415891113103097856");
    }
    @Test
    public void updateUser(){
        userRepository.updateNameById("1415891113103097856","test2");
    }
}
