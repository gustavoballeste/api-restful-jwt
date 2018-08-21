package com.gustavoballeste.api_restful_jwt.service;

import com.gustavoballeste.api_restful_jwt.api.dto.LoginDTO;
import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;

public interface UserService {

    UserDTO getById(Long id);

    UserDTO createNew(UserDTO userDTO);

    UserDTO getByLogin(LoginDTO loginDTO);
}
