package com.gustavoballeste.api_restful_jwt.api.mapper;

import com.gustavoballeste.api_restful_jwt.api.dto.PhoneDTO;

import com.gustavoballeste.api_restful_jwt.api.dto.UserDTO;

import com.gustavoballeste.api_restful_jwt.entity.Phone;

import com.gustavoballeste.api_restful_jwt.entity.User;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2018-08-24T22:20:23-0300",

    comments = "version: 1.2.0.Beta1, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"

)

@Component

public class UserMapperImpl implements UserMapper {

    @Override

    public UserDTO userToUserDTO(User user) {

        if ( user == null ) {

            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setEmail( user.getUsername() );

        userDTO.setName( user.getName() );

        userDTO.setPassword( user.getPassword() );

        List<PhoneDTO> list = phoneListToPhoneDTOList( user.getPhones() );

        if ( list != null ) {

            userDTO.setPhones( list );
        }

        return userDTO;
    }

    @Override

    public User userDTOToUser(UserDTO userDTO) {

        if ( userDTO == null ) {

            return null;
        }

        User user = new User();

        user.setUsername( userDTO.getEmail() );

        user.setName( userDTO.getName() );

        user.setPassword( userDTO.getPassword() );

        return user;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {

        if ( phone == null ) {

            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setNumber( phone.getNumber() );

        phoneDTO.setDdd( phone.getDdd() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {

        if ( list == null ) {

            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>();

        for ( Phone phone : list ) {

            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}

