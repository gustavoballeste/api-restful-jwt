package com.gustavoballeste.api_restful_jwt.api.mapper;

import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;
import com.gustavoballeste.api_restful_jwt.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
        @Mapping(source = "username", target = "email"),
        @Mapping(target = "userUrl", ignore = true)
    })
    UserDTO userToUserDTO(User user);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "phones", ignore = true),
        @Mapping(source = "email", target = "username")
    })
    User userDTOToUser(UserDTO userDTO);

}
