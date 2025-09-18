package org.example.springexperiments3.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments3.dox.UserReact;
import org.example.springexperiments3.service.UserService;
import org.example.springexperiments3.vo.RequestConstant;
import org.example.springexperiments3.vo.ResultVO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class AdminController {

    private final UserService userService;

    @PostMapping("users")
    public Mono<ResultVO> postUsers(@RequestBody UserReact user) {
        return userService.addUser(user)
                .thenReturn(ResultVO.ok());
    }

    @GetMapping("info")
    public Mono<ResultVO> getInfo(@RequestAttribute(RequestConstant.UID) String uid) {
        return userService.getUserById(uid)
                .map(ResultVO::success);
    }
}