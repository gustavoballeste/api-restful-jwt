package com.gustavoballeste.api_restful_jwt.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDTO {

    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;

    @JsonProperty("user_url")
    private String userUrl;

    public UserDTO() {
    }

    public UserDTO(String name, String email, String password, List<PhoneDTO> phones, String userUrl) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.userUrl = userUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
