package org.example.springexperiments3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments3.component.JWTComponent;
import org.example.springexperiments3.dox.UserReact;
import org.example.springexperiments3.exception.Code;
import org.example.springexperiments3.service.UserService;
import org.example.springexperiments3.vo.RequestConstant;
import org.example.springexperiments3.vo.ResultVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTComponent jwtComponent;

    @PostMapping("login")
    public Mono<ResultVO> login(@RequestBody UserReact user, ServerHttpResponse response) {
        return userService.getUser(user.getAccount())
                .filter(u -> passwordEncoder.matches(user.getPassword(), u.getPassword()))
                .map(u -> {
                    // 将主键/角色置于header
                    Map<String, Object> tokenM = Map.of(
                            RequestConstant.UID, u.getId(),
                            RequestConstant.ROLE, u.getRole());
                    String token = jwtComponent.encode(tokenM);
                    HttpHeaders headers = response.getHeaders();
                    headers.add("token", token);
                    headers.add("role", u.getRole());
                    return ResultVO.success(Map.of("user", u));
                })
                .defaultIfEmpty(ResultVO.error(Code.LOGIN_ERROR));
    }
}
