package com.gustavoballeste.api_restful_jwt.api.mapper;

import com.gustavoballeste.api_restful_jwt.api.dto.PhoneDTO;

import com.gustavoballeste.api_restful_jwt.entity.Phone;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2018-08-23T15:01:41-0300",

    comments = "version: 1.2.0.Beta1, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"

)

@Component

public class PhoneMapperImpl implements PhoneMapper {

    @Override

    public PhoneDTO phoneToPhoneDTO(Phone phone) {

        if ( phone == null ) {

            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setNumber( phone.getNumber() );

        phoneDTO.setDdd( phone.getDdd() );

        return phoneDTO;
    }

    @Override

    public Phone phoneDTOToPhone(PhoneDTO phoneDTO) {

        if ( phoneDTO == null ) {

            return null;
        }

        Phone phone = new Phone();

        phone.setDdd( phoneDTO.getDdd() );

        phone.setNumber( phoneDTO.getNumber() );

        return phone;
    }
}

