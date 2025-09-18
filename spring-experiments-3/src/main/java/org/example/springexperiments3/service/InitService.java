package org.example.springexperiments3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments3.component.JWTComponent;
import org.example.springexperiments3.dox.UserReact;
import org.example.springexperiments3.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class InitService {
    private final UserRepository userRepository;
    private final JWTComponent jwtComponent;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @EventListener(classes = ApplicationReadyEvent.class)
    public Mono<Void> onApplicationReadyEvent() {
        String account = "admin";
        return userRepository.findByAccount(account)
                .switchIfEmpty(Mono.defer(() -> {
                    UserReact user = UserReact.builder()
                            .name(account)
                            .account(account)
                            .password(passwordEncoder.encode(account))
                            .role(UserReact.ROLE_ADMIN)
                            .build();
                    return userRepository.save(user);
                }))
                .then();

    }
}
