package com.gustavoballeste.api_restful_jwt.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${user.not.found.exception}")
    String userNotFound;

    @Value("${invalid.access.exception}")
    String invalidAccessException;

    @Value("${unauthorized.exception}")
    String unauthorizedException;

    @Value("${invalid.session.exception}")
    String invalidSessionException;

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(){
        return new ResponseEntity(userNotFound, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidPasswordException.class})
    public ResponseEntity<Object> handleInvalidPasswordException(){
        return new ResponseEntity("Usuário e/ou senha inválidos", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({UnauthorizedUserException.class})
    public ResponseEntity<Object> handleUnauthorizedException(){
        return new ResponseEntity("Não Autorizado", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({RequestTimeoutException.class})
    public ResponseEntity<Object> handleRequestTimeoutException(){
        return new ResponseEntity("Sessão inválida", new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT);
    }

}
