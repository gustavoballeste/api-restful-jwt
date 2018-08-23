package com.gustavoballeste.api_restful_jwt.api.controller;

import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;
import com.gustavoballeste.api_restful_jwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newUser")
public class NewUserController {

    private final UserService userService;

    public NewUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNew(userDTO));
    }

}
