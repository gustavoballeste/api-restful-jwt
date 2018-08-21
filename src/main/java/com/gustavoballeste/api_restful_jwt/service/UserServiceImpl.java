package com.gustavoballeste.api_restful_jwt.service;

import com.gustavoballeste.api_restful_jwt.api.dto.LoginDTO;
import com.gustavoballeste.api_restful_jwt.api.dto.PhoneDTO;
import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;
import com.gustavoballeste.api_restful_jwt.api.mapper.PhoneMapper;
import com.gustavoballeste.api_restful_jwt.api.mapper.UserMapper;
import com.gustavoballeste.api_restful_jwt.entity.Phone;
import com.gustavoballeste.api_restful_jwt.entity.Role;
import com.gustavoballeste.api_restful_jwt.entity.User;
import com.gustavoballeste.api_restful_jwt.exception.ResourceNotFoundException;
import com.gustavoballeste.api_restful_jwt.repository.PhoneRepository;
import com.gustavoballeste.api_restful_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ACTUATOR = "ACTUATOR";

    static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PhoneMapper phoneMapper;

    @Value("${user.base.url}")
    private String userBaseUrl;

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDTO getById(Long id) {
        logger.info(" User: " + id);

        return userRepository.findById(id)
                .map(userMapper::userToUserDTO)
                .map(userDTO -> {
                    userDTO.setUserUrl(getUserUrl(id));
                    return userDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UserDTO createNew(UserDTO userDTO) {
        logger.info("User: " + userDTO);
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userMapper.userDTOToUser(userDTO);
        userRepository.save(savedUser);
        List<Role> userDefaultRoles = Arrays.asList(new Role(ROLE_USER), new Role(ROLE_ACTUATOR));
        savedUser.setRoles(userDefaultRoles);
        UserDTO returnDTO = userMapper.userToUserDTO(savedUser);

        List<PhoneDTO> phoneList = new ArrayList<>();
        userDTO.getPhones()
                .forEach(phoneDTO -> {
                    Phone phone = phoneMapper.phoneDTOToPhone(phoneDTO);
                    phone.setUser(savedUser);
                    phoneRepository.save(phone);
                    PhoneDTO phoneDTOReturn = phoneMapper.phoneToPhoneDTO(phone);
                    phoneList.add(phoneDTOReturn);
                });
        returnDTO.setPhones(phoneList);
        returnDTO.setUserUrl(getUserUrl(savedUser.getId()));
        return returnDTO;
    }

    @Override
    public UserDTO getByLogin(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getEmail());
        if (user != null)
            return getById(user.getId());
        else
            throw new ResourceNotFoundException();
    }

    private String getUserUrl(Long id) {
        return baseUrl + userBaseUrl + "/" + id;
    }

    private boolean validatePassword(LoginDTO loginDTO, User user) {
        return loginDTO.getEmail().equals(user.getPassword());
    }
}
