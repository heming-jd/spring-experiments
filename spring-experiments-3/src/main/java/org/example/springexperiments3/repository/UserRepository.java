package org.example.springexperiments3.repository;

import org.example.springexperiments3.dox.UserReact;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserReact, String> {
    @Query("""
            select * from user_react u where u.account=:account;
            """)
    Mono<UserReact> findByAccount(String account);

    @Query("""
            select * from user_react u where u.role=:role;
            """)
    Flux<UserReact> findByRole(String role);
}