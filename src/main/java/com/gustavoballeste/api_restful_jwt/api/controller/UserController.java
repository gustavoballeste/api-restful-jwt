package com.gustavoballeste.api_restful_jwt.api.controller;

import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;
import com.gustavoballeste.api_restful_jwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    }

}
