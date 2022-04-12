package dev.greencashew.linkshortener.controller;

import dev.greencashew.linkshortener.configuration.exception_handling.ExceptionResponse;
import dev.greencashew.linkshortener.link.api.exception.LinkAlreadyExistsException;
import dev.greencashew.linkshortener.link.api.exception.LinkNotFoundException;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Hidden
@ControllerAdvice
class ControllerAdvisor {

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(LinkAlreadyExistsException.class)
    public ExceptionResponse handleLinkAlreadyExistsException(LinkAlreadyExistsException ex) {
        return new ExceptionResponse(ex.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LinkNotFoundException.class)
    public ExceptionResponse handleLinkNotFoundException(LinkNotFoundException ex) {
        return new ExceptionResponse(ex.getMessage());
    }
}
