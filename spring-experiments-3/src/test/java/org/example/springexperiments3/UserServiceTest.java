package org.example.springexperiments3;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments3.dox.UserReact;
import org.example.springexperiments3.service.InitService;
import org.example.springexperiments3.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@SpringBootTest
@Slf4j
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void addUser() {
        UserReact u = UserReact.builder().account("qewqed").build();
        userService.addUser(u)
                .onErrorResume(e -> {
                    log.debug(e.toString());
                    return Mono.empty();
                }).block();
    }
}
