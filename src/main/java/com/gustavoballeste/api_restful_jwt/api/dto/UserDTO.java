package com.gustavoballeste.api_restful_jwt.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;

    @JsonProperty("user_url")
    private String userUrl;

}
