package com.gustavoballeste.api_restful_jwt.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneDTO {

    private Integer number;
    private Integer ddd;

}
