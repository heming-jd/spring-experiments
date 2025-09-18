package org.example.springexperiments3.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.springexperiments3.exception.Code;
import org.example.springexperiments3.exception.XException;
import org.example.springexperiments3.vo.ResultVO;
import org.springframework.r2dbc.UncategorizedR2dbcException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class ExceptionController {
    // Mono中异常转此处理
    // filter内无效，单独处理。
    @ExceptionHandler(XException.class)
    public Mono<ResultVO> handleXException(XException exception) {
        if(exception.getCode() != null) {
            return Mono.just(ResultVO.error(exception.getCode()));
        }
        return Mono.just(ResultVO.error(exception.getCodeN(), exception.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResultVO> handleException(Exception exception) {
        return Mono.just(ResultVO.error(Code.BAD_REQUEST.getCode(), exception.getMessage()));
    }

    @ExceptionHandler(UncategorizedR2dbcException.class)
    public Mono<ResultVO> handelUncategorizedR2dbcException(UncategorizedR2dbcException exception) {
        return Mono.just(ResultVO.error(Code.BAD_REQUEST.getCode(), "唯一约束冲突！" + exception.getMessage()));
    }
}
