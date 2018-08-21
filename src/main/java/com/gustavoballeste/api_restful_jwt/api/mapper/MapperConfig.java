package com.gustavoballeste.api_restful_jwt.api.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {

    @Bean
    public UserMapper userMapper() {
        return UserMapper.INSTANCE;
    }

    @Bean
    public PhoneMapper phoneMapper() {
        return PhoneMapper.INSTANCE;
    }
}
