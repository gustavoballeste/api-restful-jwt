package com.gustavoballeste.api_restful_jwt.api.mapper;

import com.gustavoballeste.api_restful_jwt.api.dto.PhoneDTO;
import com.gustavoballeste.api_restful_jwt.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    PhoneDTO phoneToPhoneDTO(Phone phone);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "user", ignore = true)
    })
    Phone phoneDTOToPhone(PhoneDTO phoneDTO);
}
