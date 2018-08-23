package com.gustavoballeste.api_restful_jwt.api.controller;

import com.gustavoballeste.api_restful_jwt.api.dto.LoginDTO;
import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;
import com.gustavoballeste.api_restful_jwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getByLogin(loginDTO));
    }

}
